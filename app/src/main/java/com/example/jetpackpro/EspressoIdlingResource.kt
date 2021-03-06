package com.example.jetpackpro

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private val RESOUCE: String? = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOUCE)

    fun increment(){
        espressoTestIdlingResource.increment()
    }

    fun decrement(){
        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResource() : IdlingResource {
        return espressoTestIdlingResource
    }
}