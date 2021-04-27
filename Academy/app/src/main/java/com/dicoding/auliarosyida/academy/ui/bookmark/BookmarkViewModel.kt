package com.dicoding.auliarosyida.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.utils.DataDummy

class BookmarkViewModel: ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}