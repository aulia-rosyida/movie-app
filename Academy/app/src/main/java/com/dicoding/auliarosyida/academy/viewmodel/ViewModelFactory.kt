package com.dicoding.auliarosyida.academy.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.di.Injection
import com.dicoding.auliarosyida.academy.ui.academy.AcademyViewModel
import com.dicoding.auliarosyida.academy.ui.bookmark.BookmarkViewModel
import com.dicoding.auliarosyida.academy.ui.detail.DetailCourseViewModel
import com.dicoding.auliarosyida.academy.ui.reader.CourseReaderViewModel

/**
 * ViewModelFactory buatan sendiri, fungsinya yaitu untuk memasukkan AcademyRepository ke dalam ViewModel.
 * */
class ViewModelFactory private constructor(private val mAcademyRepository: AcademyRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(AcademyViewModel::class.java) -> {
                return AcademyViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(DetailCourseViewModel::class.java) -> {
                return DetailCourseViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                return BookmarkViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(CourseReaderViewModel::class.java) -> {
                return CourseReaderViewModel(mAcademyRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}