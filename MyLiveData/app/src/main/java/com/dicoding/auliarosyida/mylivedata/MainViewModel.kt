package com.dicoding.auliarosyida.mylivedata

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel: ViewModel() {

    companion object {
        private const val ONE_SECOND = 1000
    }

    // metode untuk menjalankan timer di konstruktor
    private val mInitialTime = SystemClock.elapsedRealtime()
    private val mElapsedTime = MutableLiveData<Long?>() //obyek LiveData yang nantinya akan di-subscribe oleh MainActivity.

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                mElapsedTime.postValue(newValue) //merubah value-nya adalah pada bagian ini.
            // menyisipkan perubahan yang terjadi dengan postValue(), jadi secara realtime MutableLiveData akan menerima data yang baru
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }

    /**
     * terdapat LiveData dan MutableLiveData.
     *
     * Lalu apa bedanya? Keduanya sebenarnya mirip
     * bedanya MutableLiveData bisa kita ubah value-nya,
     * sedangkan LiveData bersifat Read-Only.
     * */
    fun getElapsedTime(): LiveData<Long?> {
        return mElapsedTime
    }
}