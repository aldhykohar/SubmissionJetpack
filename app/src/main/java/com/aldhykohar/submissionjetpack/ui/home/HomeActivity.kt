package com.aldhykohar.submissionjetpack.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldhykohar.submissionjetpack.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val adapter: SectionsPagerAdapter by lazy {
        SectionsPagerAdapter(this, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        supportActionBar?.elevation = 0f
        with(binding) {
            viewPager.adapter = adapter
            tabs.setupWithViewPager(viewPager)
        }
    }
}