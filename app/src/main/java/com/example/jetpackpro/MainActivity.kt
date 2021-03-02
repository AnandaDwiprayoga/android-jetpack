package com.example.jetpackpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        displayResult()

        activityMainBinding.btnSave.setOnClickListener(this)
    }

    private fun displayResult() {
       activityMainBinding.tvResult.text = mainViewModel.result.toString()
    }

    override fun onClick(v: View?) {
        val length = activityMainBinding.edtLength.text.toString().trim()
        val width = activityMainBinding.edtWidth.text.toString().trim()
        val height = activityMainBinding.edtHeight.text.toString().trim()

        when {
            TextUtils.isEmpty(length) -> {
                activityMainBinding.edtLength.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(width) -> {
                activityMainBinding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(height) -> {
                activityMainBinding.edtHeight.error = "Field ini tidak boleh kosong"
            }
            else -> {
                when (v?.id) {
                    R.id.btn_save -> {
                        mainViewModel.calculate(width, height, length)
                        displayResult()
                    }
                }
            }
        }
    }

}