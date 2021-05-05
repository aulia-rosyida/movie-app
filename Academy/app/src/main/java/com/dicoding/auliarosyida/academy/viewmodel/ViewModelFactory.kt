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

        /**
         * Method getInstance berfungsi untuk membuat kelas ViewModelFactory sebagai Singleton.
         * Fungsinya yaitu supaya tercipta satu instance saja di dalam JVM, sehingga tidak memakan memori yang terbatas.
         * Jadi setiap Activity memanggil ViewModelFactory, kelas itu akan membuat instance jika belum dibuat sebelumnya,
         * lalu jika Activity B memanggil fungsi ini, kelas tersebut akan memeriksa apakah instance-nya sudah ada.
         *
         * Jika iya, akan mengembalikan instance tersebut pada Activity B,
         * jika tidak membuat instance baru.
         * */
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) { //kode synchronized untuk membuat semua thread tersinkronisasi.
                                                   // Dengan cara ini, hanya satu thread yang boleh menjalankan fungsi yang sama di waktu yang sama.
                                                        // Khusus di sistem Android, terdapat Multi-threading yang bisa menjalankan kode di thread yang berbeda-beda,
                                                        // sehingga bisa saja instance dibuat di thread yang berbeda.

                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply { //menggunakan Injection, ViewModelFactory mampu menyediakan kebutuhan AcademyRepository.
                    instance = this
                }
            }
    }

    /**
     * Setiap ada ViewModel dalam aplikasi dan membutuhkan AcademyRepository, Anda perlu mendaftarkan ViewModel tersebut di dalam ViewModelFactory.
     * Jika tidak, ViewModelFactory tidak akan mengenali kelas ViewModel tersebut.
     * */
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