package com.dicoding.auliarosyida.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel(){

    fun getCourses(): LiveData<List<CourseEntity>> =  academyRepository.getAllCourses()
}