package com.aldhykohar.submissionjetpack.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.aldhykohar.submissionjetpack.databinding.ActivitySplashBinding
import com.aldhykohar.submissionjetpack.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        goToHome()
    }

    private fun goToHome() {
        Handler(mainLooper).postDelayed(
            { startActivity(Intent(this, HomeActivity::class.java)) },
            3000
        )
    }
}