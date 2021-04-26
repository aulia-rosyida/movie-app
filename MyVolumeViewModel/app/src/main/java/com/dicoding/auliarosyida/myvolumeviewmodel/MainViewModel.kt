package com.dicoding.auliarosyida.myvolumeviewmodel

import androidx.lifecycle.ViewModel

/**
 * turunan kelas ViewModel ke kelas MainViewModel, itu menandakan bahwa kelas tersebut menjadi kelas ViewModel.
 * Segala sesuatu yang ada di kelas tersebut akan terjaga selama Activity masih dalam keadaan aktif.
 */
class MainViewModel : ViewModel() {
    var result = 0 //nilai dari result akan selalu dipertahankan selama MainViewModel masih terikat dengan Activity.

    /**
     *  metode calculate yang berfungsi untuk melakukan perkalian dari input lebar, panjang dan tinggi.
     * */
    fun calculate(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }
}