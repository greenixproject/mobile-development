package com.bangkit2023.capstone.greenix.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bangkit2023.capstone.greenix.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private var _splashBinding: ActivitySplashBinding? = null
    private val splashBinding get() = _splashBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delayMillis)
    }

    private companion object {
        const val delayMillis = 3000L
    }
}