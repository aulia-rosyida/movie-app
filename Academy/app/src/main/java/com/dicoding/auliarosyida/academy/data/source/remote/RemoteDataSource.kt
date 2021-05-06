package com.dicoding.auliarosyida.academy.data.source.remote

import android.os.Handler
import android.os.Looper
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

    /**
     * Handler dari package android.os ketika pengambilan data.
     * Handler berfungsi untuk memberikan waktu delay sesuai dengan kebutuhan.
     *
     *  Handler untuk delay, seperti yang dilakukan di sini merupakah hal yang tidak disarankan.
     *  Karena aplikasi yang kita buat hanyalah simulasi, di mana data yang diperoleh disimulasikan berasal dari server atau API.
     *  Maka dari itu, penggunaan Handler pada aplikasi Academy digunakan untuk mensimulasikan proses asynchonous yang terjadi.
     * */
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

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

    //semua data yang diambil dari Repository sampai ke ViewModel akan dibungkus dengan LiveData
    fun getAllCourses(callback: LoadCoursesCallback) {
        handler.postDelayed({ callback.onAllCoursesReceived(jsonHelper.loadCourses()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getModules(courseId: String, callback: LoadModulesCallback) {
        handler.postDelayed({ callback.onAllModulesReceived(jsonHelper.loadModule(courseId)) }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getContent(moduleId: String, callback: LoadContentCallback) {
        handler.postDelayed({ callback.onContentReceived(jsonHelper.loadContent(moduleId)) }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadCoursesCallback {
        fun onAllCoursesReceived(courseResponses: List<CourseResponse>)
    }
    interface LoadModulesCallback {
        fun onAllModulesReceived(moduleResponses: List<ModuleResponse>)
    }
    interface LoadContentCallback {
        fun onContentReceived(contentResponse: ContentResponse)
    }

}