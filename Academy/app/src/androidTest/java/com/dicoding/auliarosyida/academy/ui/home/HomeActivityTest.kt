package com.dicoding.auliarosyida.academy.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.auliarosyida.academy.R
import com.dicoding.auliarosyida.academy.utils.DataDummy
import org.junit.Before
import org.junit.Test

/**
 * Anda menggunakan Espresso dalam melakukan Instrumental Testing, berikut adalah 3 komponen utamanya:
 *
 * ViewMatchers (onView(ViewMatcher)): untuk menemukan elemen atau komponen antarmuka yang diuji.
 * ViewActions (perform(ViewAction)): untuk memberikan event untuk melakukan sebuah aksi pada komponen antarmuka yang diuji.
 * ViewAssertions: sebuah kondisi atau state dari komponen yang diuji.
 * */class HomeActivityTest {

    private val dummyCourse = DataDummy.generateDummyCourses()

    @Before
    fun setup(){
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadCourses() {
        delayTwoSecond()
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }

    @Test
    fun loadDetailCourse() {
        delayTwoSecond()
        delayTwoSecond()
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        delayTwoSecond()
        delayTwoSecond()
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyCourse[0].title)))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(matches(withText("Deadline ${dummyCourse[0].deadline}")))
    }

    @Test
    fun loadModule() {
        delayTwoSecond()
        delayTwoSecond()
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        delayTwoSecond()
        onView(withId(R.id.btn_start)).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailModule() {
        delayTwoSecond()
        delayTwoSecond()
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        delayTwoSecond()
        onView(withId(R.id.btn_start)).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_module)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        delayTwoSecond()
        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }

    @Test
    fun loadBookmarks() {
        onView(withText("Bookmark")).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }

    /**
     * Pada saat Aplikasi mengambil data di RemoteDataSource , terdapat delay di saat proses pengambilan data.
     * Oleh karena itu, di InstrumentalTesting perlu Anda tambahkan proses delay.
     *
     * Namun perlu Anda ketahui, penambahan delay di RemoteDataSource bermaksud untuk memberikan simulasi pengambilan Api lebih nyata.
     * Realitanya, proses tunggu atau delay ini tidak bisa diprediksi secara pasti karena prosesnya asynchronous.
     * Oleh karena itu pada materi selanjutnya kita akan membahas tentang Idle Resource.
     * */
    private fun delayTwoSecond() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}