package com.dicoding.auliarosyida.myidlingresource

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private val RESOURCE: String? = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    //Increment digunakan untuk menambahkan state loading
    fun increment() {
        espressoTestIdlingResource.increment()
    }

    //decrement untuk mengurangi state loading-nya
    fun decrement() {
        espressoTestIdlingResource.decrement()
    }
    fun getEspressoIdlingResource(): IdlingResource {
        return espressoTestIdlingResource
    }
}