package com.dicoding.auliarosyida.myvolumeviewmodel

import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel

    /**
     * Annotation @Rule digunakan untuk menjalankan kode sebelum pengujian dilakukan.
     * Jadi jika tidak diberi anotasi  @Rule pada thrown, maka kode tersebut tidak akan berjalan.
     * Untuk menggunakan ExpectedException, Anda perlu menggunakan anotasi Rule untuk memberi aturan pada pengujian .
     * */
    @get:Rule
    var thrown = ExpectedException.none()

    /**
     * Untuk menginisialisasi ViewModel, Anda perlu melakukannya di dalam method init() dengan anotasi @Before.
     * Anotasi ini berfungsi untuk melakukan serangkaian persiapan sebelum melakukan pengujian.
     * */
    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val width = "1"
        val length = "3"
        val height = "2"
        mainViewModel.calculate(width, height, length)
        assertEquals(6, mainViewModel.result) // assertEquals berguna untuk membandingkan antara ekspektasi dan hasil aktual perhitungan
    }

    /**
     * Ekspektasi Anda bahwa eror tersebut terjadi karena NumberFormatException,
     * bahkan Anda juga mencocokkan pesan dari eror yang terjadi dengan ekspektasi Anda.
     * NumberFormatException akan terjadi saat Anda mencoba mengubah String menjadi nilai angka namun String tersebut tidak terformat dengan benar.
     * Misalnya dalam kasus tersebut ekspektasi Anda adalah Integer, namun aktualnya adalah String.
     * */
    @Test
    @Throws(NumberFormatException::class)
    fun doubleInputCalculateTest() {
        val width = "1"
        val length = "2.4"
        val height = "3"
        thrown.expect(NumberFormatException::class.java) // memastikan apakah pesan eror yang terjadi sesuai dengan ekspektasi
        thrown.expectMessage("For input string: \"2.4\"") //ekspektasinya yaitu variable yang dimasukkan bukan integer, melainkan double.
        mainViewModel.calculate(width, height, length)
    }

    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun characterInputCalculateTest() {
        val width = "1"
        val length = "A"
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"A\"")
        mainViewModel.calculate(width, length, height)
    }


    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun emptyInputCalculateTest() {
        val width = "1"
        val length = ""
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"\"")
        mainViewModel.calculate(width, height, length)
    }
}