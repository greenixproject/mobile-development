package com.bangkit2023.capstone.greenix.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2023.capstone.greenix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _activityMainBinding: ActivityMainBinding? = null
    private val activityMainBinding get() = _activityMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }
}