package com.dicoding.auliarosyida.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()
}