package com.dicoding.auliarosyida.academy.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.data.ModuleEntity
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.utils.DataDummy

/**
 *  kode pada kelas tersebut untuk menetapkan atau mendapatkan courseId, mendapatkan list module dan mendapatkan CourseEntity.
 * */
class DetailCourseViewModel(private val academyRepository: AcademyRepository): ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse() = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
}