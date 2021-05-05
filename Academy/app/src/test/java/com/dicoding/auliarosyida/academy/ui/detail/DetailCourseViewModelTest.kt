package com.dicoding.auliarosyida.academy.ui.detail

import com.dicoding.auliarosyida.academy.data.ModuleEntity
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Memuat Course:
- Memanipulasi data ketika pemanggilan data course di kelas repository.
- Memastikan metode di kelas repository terpanggil.
- Melakukan pengecekan data course apakah null atau tidak.
- Membandingkan data course sudah sesuai dengan yang diharapkan atau tidak.

* Memuat Modules:
- Memanipulasi data ketika pemanggilan data module di kelas repository.
- Memastikan metode di kelas repository terpanggil.
- Melakukan pengecekan data module apakah null atau tidak.
- Melakukan pengecekan jumlah data module apakah sudah sesuai atau belum.
 * */

@RunWith(MockitoJUnitRunner::class)
class DetailCourseViewModelTest {
    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId)
    }

    /**
     * membandingkan data CourseEntity hasil dari viewModel.getCourses().
     * */
    @Test
    fun getCourse() {
        `when`(academyRepository.getCourseWithModules(courseId)).thenReturn(dummyCourse)
        val courseEntity = viewModel.getCourse()
        verify(academyRepository).getCourseWithModules(courseId)

        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

    /**
     *menguji DetailCourseViewModel dengan cara membandingkan ukuran dari array viewModel.getModules()
     * */
    @Test
    fun getModules() {
        `when`(academyRepository.getAllModulesByCourse(courseId)).thenReturn(DataDummy.generateDummyModules(courseId) as ArrayList<ModuleEntity>?)
        val moduleEntities = viewModel.getModules()
        verify(academyRepository).getAllModulesByCourse(courseId)
        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities.size.toLong())
    }
}