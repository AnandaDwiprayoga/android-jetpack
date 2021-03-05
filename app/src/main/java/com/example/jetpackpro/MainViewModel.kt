package com.example.jetpackpro

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    companion object {
        private const val ONE_SECOND = 1000
    }

    private val mInitialTime = SystemClock.elapsedRealtime()

    private val _mElapsedTime = MutableLiveData<Long>()
    val mElapsedTime : LiveData<Long> = _mElapsedTime


    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                 val value = (SystemClock.elapsedRealtime() - mInitialTime) / 100
                _mElapsedTime.postValue(value)
            }

        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }
}