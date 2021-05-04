package com.dicoding.auliarosyida.academy.data.source

import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.data.ModuleEntity

/**
 *  interface yang nantinya akan digunakan untuk menggabungkan 2 repository
 * */
interface AcademyDataSource {

    fun getAllCourses(): List<CourseEntity>

    fun getBookmarkedCourses(): List<CourseEntity>

    fun getCourseWithModules(courseId: String): CourseEntity

    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>

    fun getContent(courseId: String, moduleId: String): ModuleEntity

}