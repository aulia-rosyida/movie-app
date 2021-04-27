package com.dicoding.auliarosyida.academy.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.auliarosyida.academy.R
import com.dicoding.auliarosyida.academy.databinding.ActivityHomeBinding

/**
 * HomeActivity: Menampilkan 2 Fragment (AcademyFragment dan BookmarkFragment) dan sebagai halaman utama dari Aplikasi.
 * */
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)
        supportActionBar?.elevation = 0f

    }
}