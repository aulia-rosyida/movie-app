package com.dicoding.auliarosyida.moviesapp.utils

import androidx.test.espresso.idling.CountingIdlingResource

object IdlingResourceEspresso {
    private const val RESOURCE = "GLOBAL"
    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }
}