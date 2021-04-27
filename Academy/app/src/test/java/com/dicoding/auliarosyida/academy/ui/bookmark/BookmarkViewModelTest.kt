package com.dicoding.auliarosyida.academy.ui.bookmark

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class BookmarkViewModelTest {
    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel()
    }

    /**
     * menguji apakah metode getBookmark sudah benar atau belum.
     * */
    @Test
    fun getBookmark() {
        val courseEntities = viewModel.getBookmarks()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}