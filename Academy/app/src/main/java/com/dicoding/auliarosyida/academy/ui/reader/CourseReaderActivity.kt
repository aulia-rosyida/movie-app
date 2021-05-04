package com.dicoding.auliarosyida.academy.ui.reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dicoding.auliarosyida.academy.R
import com.dicoding.auliarosyida.academy.ui.reader.content.ModuleContentFragment
import com.dicoding.auliarosyida.academy.ui.reader.list.ModuleListFragment
import com.dicoding.auliarosyida.academy.viewmodel.ViewModelFactory

/**
 * CourseReader: Menampilkan 2 Fragment(ModuleListFragment dan ModuleContentFragment)
 * dan di Activity ini nanti akan ada 2 tampilan yakni untuk ukuran layar yang besar dan kecil.
 * */
class CourseReaderActivity : AppCompatActivity(), CourseReaderCallback {

    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[CourseReaderViewModel::class.java]

        val bundle = intent.extras
        if (bundle != null) {
            val courseId = bundle.getString(EXTRA_COURSE_ID)
            if (courseId != null) {
                viewModel.setSelectedCourse(courseId)
                populateFragment()
            }
        }
    }

    /**
     * Metode moveTo digunakan untuk memanggil ModuleContentFragment sesuai dengan posisi dan moduleId yang dipilih.
     * */
    override fun moveTo(position: Int, moduleId: String) {
        val fragment = ModuleContentFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
                .addToBackStack(null)
                .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun populateFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleListFragment.TAG)
        if (fragment == null) {
            fragment = ModuleListFragment.newInstance()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }
}