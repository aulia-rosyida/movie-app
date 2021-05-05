package com.dicoding.auliarosyida.academy.ui.academy

import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Memuat Courses:
- Memanipulasi data ketika pemanggilan data course di kelas repository.
- Memastikan metode di kelas repository terpanggil.
- Melakukan pengecekan data course apakah null atau tidak.
- Melakukan pengecekan jumlah data course apakah sudah sesuai atau belum.
 * */

@RunWith(MockitoJUnitRunner::class)
class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    /**
     * AcademyRepository yang di-mock mengakibatkan pemanggilan data dari AcademyRepository menjadi null.
     * Mocking dilakukan dengan mengganti bagian AcademyRepository dengan objek tiruan (FakeAcademyRepository)
     * */
    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = AcademyViewModel(academyRepository)
    }


    /**
     * kita gunakan bantuan when untuk memanipulasi pemanggilan getAllCourses() dengan mengembalikan DataDummy.
     * */
    @Test
    fun getCourses() {
        `when`(academyRepository.getAllCourses()).thenReturn(DataDummy.generateDummyCourses() as ArrayList<CourseEntity>)
        val courseEntities = viewModel.getCourses()
        verify<AcademyRepository>(academyRepository).getAllCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}