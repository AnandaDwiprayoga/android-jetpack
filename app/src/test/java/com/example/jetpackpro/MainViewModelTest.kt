package com.example.jetpackpro

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.ExpectedException

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
    }

    @get:Rule
    var thrown: ExpectedException = ExpectedException.none()

    @Test
    fun calculate() {
        val width = "1"
        val length = "2"
        val height = "3"
        mainViewModel.calculate(width,height,length)
        assertEquals(6, mainViewModel.result)
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