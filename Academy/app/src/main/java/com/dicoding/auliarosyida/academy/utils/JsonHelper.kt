package com.dicoding.auliarosyida.academy.utils

import android.content.Context
import com.dicoding.auliarosyida.academy.data.source.remote.response.ContentResponse
import com.dicoding.auliarosyida.academy.data.source.remote.response.CourseResponse
import com.dicoding.auliarosyida.academy.data.source.remote.response.ModuleResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

/**
 * kode berikut untuk mengubah JSON menjadi String
 * */
class JsonHelper(private val context: Context) {

    /**
     * mengubah file JSON menjadi String.
     *
     * Anda bisa juga parsingFileToString dengan melakukan request langsung ke API.
     * Prinsipnya sama, setelah jadi String akan di ubah menjadi array sesuai kebutuhan aplikasi Anda.
     * */
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    /**
     * untuk mendapatkan semua data Course
     * parsingFileToString dengan melakukan request langsung ke API.
     * */
    fun loadCourses(): List<CourseResponse> {
        val list = ArrayList<CourseResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CourseResponses.json").toString())

            //Hasil dari String di ubah menjadi JSONObject dan di ubah menjadi CourseResponse
            val listArray = responseObject.getJSONArray("courses")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)

                val id = course.getString("id")
                val title = course.getString("title")
                val description = course.getString("description")
                val date = course.getString("date")
                val imagePath = course.getString("imagePath")

                val courseResponse = CourseResponse(id, title, description, date, imagePath)
                list.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadModule(courseId: String): List<ModuleResponse> {
        val fileName = String.format("Module_%s.json", courseId)
        val list = ArrayList<ModuleResponse>()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("modules")
                for (i in 0 until listArray.length()) {
                    val course = listArray.getJSONObject(i)

                    val moduleId = course.getString("moduleId")
                    val title = course.getString("title")
                    val position = course.getString("position")

                    val courseResponse = ModuleResponse(moduleId, courseId, title, Integer.parseInt(position))
                    list.add(courseResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadContent(moduleId: String): ContentResponse {
        val fileName = String.format("Content_%s.json", moduleId)
        var contentResponse: ContentResponse? = null
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val content = responseObject.getString("content")
                contentResponse = ContentResponse(moduleId, content)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return contentResponse as ContentResponse
    }
}