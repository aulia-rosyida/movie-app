package com.dicoding.auliarosyida.academy.ui.academy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() //InstantTaskExecutorRule karena pengujiannya berupa proses asynchronous

    /**
     * AcademyRepository yang di-mock mengakibatkan pemanggilan data dari AcademyRepository menjadi null.
     * Mocking dilakukan dengan mengganti bagian AcademyRepository dengan objek tiruan (FakeAcademyRepository)
     * */
    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Mock
    private lateinit var observer: Observer<List<CourseEntity>>


    @Before
    fun setUp() {
        viewModel = AcademyViewModel(academyRepository)
    }


    /**
     * kita gunakan bantuan when untuk memanipulasi pemanggilan getAllCourses() dengan mengembalikan DataDummy.
     * */
    @Test
    fun getCourses() {
        val dummyCourses = DataDummy.generateDummyCourses()
        val courses = MutableLiveData<List<CourseEntity>>()
        courses.value = dummyCourses

        `when`(academyRepository.getAllCourses()).thenReturn(courses)
        val courseEntities = viewModel.getCourses().value
        verify(academyRepository).getAllCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities?.size)

        viewModel.getCourses().observeForever(observer) //observeForever digunakan untuk meng-observe secara terus menerus
        verify(observer).onChanged(dummyCourses) //onChanged digunakan untuk memastikan terjadi perubahan data di LiveData
    }
}