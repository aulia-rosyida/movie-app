package com.dicoding.auliarosyida.moviesapp.ui.landingpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.auliarosyida.moviesapp.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityLandingBinding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(activityLandingBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityLandingBinding.viewPager.adapter = sectionsPagerAdapter
        activityLandingBinding.tabs.setupWithViewPager(activityLandingBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}