package com.dicoding.auliarosyida.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dicoding.auliarosyida.mylivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mLiveDataTimerViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mLiveDataTimerViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}