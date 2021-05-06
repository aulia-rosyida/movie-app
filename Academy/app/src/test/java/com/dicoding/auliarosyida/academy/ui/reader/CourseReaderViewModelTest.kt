package com.dicoding.auliarosyida.academy.ui.reader

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.auliarosyida.academy.data.ContentEntity
import com.dicoding.auliarosyida.academy.data.ModuleEntity
import com.dicoding.auliarosyida.academy.data.source.AcademyRepository
import com.dicoding.auliarosyida.academy.utils.DataDummy
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Memuat Modules:
- Memanipulasi data ketika pemanggilan data module di kelas repository.
- Memastikan metode di kelas repository terpanggil.
- Melakukan pengecekan data module apakah null atau tidak.
- Melakukan pengecekan jumlah data module apakah sudah sesuai atau belum.

* Memuat Module yang dipilih:
- Memanipulasi data ketika pemanggilan data content di kelas repository.
- Memastikan metode di kelas repository terpanggil.
- Melakukan pengecekan data content apakah null atau tidak.
- Membandingkan data content sudah sesuai dengan yang diharapkan atau tidak.
 * */

@RunWith(MockitoJUnitRunner::class)
class CourseReaderViewModelTest  {

    private lateinit var viewModel: CourseReaderViewModel

    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId
    private val dummyModules = DataDummy.generateDummyModules(courseId)
    private val moduleId = dummyModules[0].moduleId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Mock
    private lateinit var modulesObserver: Observer<List<ModuleEntity>>

    @Mock
    private lateinit var moduleObserver: Observer<ModuleEntity>

    @Before
    fun setUp() {
        viewModel = CourseReaderViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId)
        viewModel.setSelectedModule(moduleId)

        val dummyModule = dummyModules[0]
        dummyModule.contentEntity = ContentEntity("<h3 class=\\\"fr-text-bordered\\\">"+dummyModule.title+"</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
    }

    /**
     * menguji CourseReaderViewModel dengan cara membandingkan ukuran dari array viewModel.getModules()
     * */
    @Test
    fun getModules() {

        val modules = MutableLiveData<List<ModuleEntity>>()
        modules.value = dummyModules

        `when`(academyRepository.getAllModulesByCourse(courseId)).thenReturn(modules)
        val moduleEntities = viewModel.getModules().value
        verify(academyRepository).getAllModulesByCourse(courseId)
        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities?.size)

        viewModel.getModules().observeForever(modulesObserver)
        verify(modulesObserver).onChanged(dummyModules)
    }

    /**
     *  membandingkan data ModuleEntity hasil dari viewModel.getSelectedModule().
     * */
    @Test
    fun getSelectedModule() {
        val module = MutableLiveData<ModuleEntity>()
        module.value = dummyModules[0]

        `when`(academyRepository.getContent(courseId, moduleId)).thenReturn(module) // setiap pengujian harus ditambahkan when.thenReturn
                                                                                             // untuk mendapatkan balikan yang diinginkan.
                                                                                             // Karena jika tanpa when.thenReturn AcademyRepository menjadi null.
        val moduleEntity = viewModel.getSelectedModule().value as ModuleEntity
        verify(academyRepository).getContent(courseId, moduleId)
        assertNotNull(moduleEntity)

        val contentEntity = moduleEntity.contentEntity
        assertNotNull(contentEntity)

        val content = contentEntity?.content
        assertNotNull(content)
        assertEquals(content, dummyModules[0].contentEntity?.content)

        viewModel.getSelectedModule().observeForever(moduleObserver)
        verify(moduleObserver).onChanged(dummyModules[0])
    }
}