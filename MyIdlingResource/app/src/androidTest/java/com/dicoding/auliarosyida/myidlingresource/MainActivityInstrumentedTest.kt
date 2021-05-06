package com.dicoding.auliarosyida.myidlingresource

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Skenario pengujian dari kode di atas adalah:
1. Memastikan value yang tampil di text_view sesuai dengan ekspektasi.
2. Memberikan aksi klik pada view yang mempunyai teks start.
3. Memastikan value yang tampil di text_view mengalami perubahan sesuai dengan ekspektasi.
 --> eror karena ada waktu delay (simulasi proses asychronous) antara proses klik dengan pengecekan hasil perubahan text_view
 * */

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityInstrumentedTest {

    private lateinit var instrumentalContext: Context

    //@Before digunakan untuk menyiapkan apa saja yang perlu disiapkan sebelum pengujian
    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext
        ActivityScenario.launch(MainActivity::class.java)

        //getEspressoIdlingResource digunakan untuk mendaftarkan Idling Resource di Instrumental Testing
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    //@After digunakan untuk memberi aksi setelah pengujian selesai.
    @After
    fun tearDown() {
        // pastikan setelah Anda berhasil melakukan pengujian, Anda menghapus increment dan decrement dari kode Anda. Karena itu bisa menimbulkan memory leak.
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun checkText() {
        onView(withId(R.id.text_view)).check(matches(withText(instrumentalContext.getString(R.string.prepare))))
        onView(withText(instrumentalContext.getString(R.string.start))).perform(click())

        /**
         * Idling Resource hanya akan bekerja jika benar-benar dalam kondisi 0. Jadi Anda tidak bisa melakukan pengujian untuk teks delay1
         * Selama state dari idling resource belum kondisi 0, maka proses pengujian akan berhenti sampai benar-benar 0 kembali.
         */
        //onView(withId(R.id.text_view)).check(matches(withText(instrumentalContext.getString(R.string.delay1))))
        onView(withId(R.id.text_view)).check(matches(withText(instrumentalContext.getString(R.string.delay2))))
    }

}