package com.dicoding.auliarosyida.moviesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dicoding.auliarosyida.moviesapp.R
import com.dicoding.auliarosyida.moviesapp.ui.landingpage.LandingActivity

class SplashScreen : AppCompatActivity() {
    private val timeout :Long=3000 // 3 s

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, LandingActivity::class.java))

            // close this activity
            finish()
        }, timeout)
    }
}