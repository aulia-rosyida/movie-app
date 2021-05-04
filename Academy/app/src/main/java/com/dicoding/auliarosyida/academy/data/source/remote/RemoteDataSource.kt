package com.dicoding.auliarosyida.academy.data.source.remote

import com.dicoding.auliarosyida.academy.data.source.remote.response.ContentResponse
import com.dicoding.auliarosyida.academy.data.source.remote.response.CourseResponse
import com.dicoding.auliarosyida.academy.data.source.remote.response.ModuleResponse
import com.dicoding.auliarosyida.academy.utils.JsonHelper

/**
 *  kelas repository untuk remote
 *
 *  bagaimana RemoteDataSource di panggil:
 *  Ketika Anda memanggil RemoteDataSource, kelas tersebut membutuhkan masukan Context untuk inisialisasi JsonHelper.
 *  Context ini digunakan untuk mengambil data dari asset.
 *  Jadi Anda harus membuat kelas Injection, untuk meng-inject context ke dalam RemoteDataSource ketika ViewModel dipanggil.
 * */
class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        /**
         *  method getInstance yang berfungsi untuk membuat kelas RemoteDataSource sebagai Singleton.
         *  Fungsinya yaitu supaya tercipta satu instance saja di dalam JVM.
         * */
        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllCourses(): List<CourseResponse> = jsonHelper.loadCourses()

    fun getModules(courseId: String): List<ModuleResponse> = jsonHelper.loadModule(courseId)

    fun getContent(moduleId: String): ContentResponse = jsonHelper.loadContent(moduleId)

}