package com.dicoding.auliarosyida.academy.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.auliarosyida.academy.R
import com.dicoding.auliarosyida.academy.utils.DataDummy
import org.junit.Rule
import org.junit.Test

/**
 * Anda menggunakan Espresso dalam melakukan Instrumental Testing, berikut adalah 3 komponen utamanya:
 *
 * ViewMatchers (onView(ViewMatcher)): untuk menemukan elemen atau komponen antarmuka yang diuji.
 * ViewActions (perform(ViewAction)): untuk memberikan event untuk melakukan sebuah aksi pada komponen antarmuka yang diuji.
 * ViewAssertions: sebuah kondisi atau state dari komponen yang diuji.
 * */
class HomeActivityTest {

    private val dummyCourse = DataDummy.generateDummyCourses()

    /**
     * Fungsi dari ActivityScenarioRule yaitu untuk menjalankan Activity tertentu sebelum pengujian dimulai
     * dan ditutup setelah pengujian. Dalam hal ini, activity yang dijalankan yaitu HomeActivity
     * */
    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadCourses() {
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }

    @Test
    fun loadDetailCourse() {
        // kode RecyclerViewActions yang digunakan untuk pengujian pada RecyclerView seperti scroll ke posisi tertentu dan klik pada posisi tertentu.
        // hasil penambahan library espresso-contrib
        /**
         *  ketika Anda membuat sebuah fitur, Anda perlu menyiapkan skenario pengujian untuk menguji fitur tersebut.
         *  Karena jika tidak, Aplikasi yang Anda buat bisa saja menyimpan eror atau bug yang tidak Anda ketahui.
         * */
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyCourse[0].title)))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(matches(withText("Deadline ${dummyCourse[0].deadline}")))
    }

    @Test
    fun loadModule() {
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailModule() {
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.rv_module)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }

    @Test
    fun loadBookmarks() {
        onView(withText("Bookmark")).perform(click())
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }
}