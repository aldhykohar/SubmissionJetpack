package com.aldhykohar.submissionjetpack.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.aldhykohar.submissionjetpack.R
import com.aldhykohar.submissionjetpack.databinding.ActivityHomeBinding
import com.aldhykohar.submissionjetpack.ui.favorite.FavoriteActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarTitle.text = "Movie DB"
    }

    private fun setupUI() {
        supportActionBar?.elevation = 0f
        with(binding) {
            viewPager.adapter = adapter
            tabs.setupWithViewPager(viewPager)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_fav) {
            startActivity(Intent(this, FavoriteActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}