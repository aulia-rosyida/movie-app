package com.dicoding.auliarosyida.academy.ui.academy

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel
    @Before
    fun setUp() {
        viewModel = AcademyViewModel()
    }


    @Test
    fun getCourses() {
        val courseEntities = viewModel.getCourses()
        assertNotNull(courseEntities)

        /**
         * menguji AcademyViewModel dengan cara membandingkan ukuran dari array viewModel.getCourses().
         * */
        assertEquals(5, courseEntities.size)
    }
}