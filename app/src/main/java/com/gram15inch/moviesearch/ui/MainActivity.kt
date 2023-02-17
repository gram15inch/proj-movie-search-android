package com.gram15inch.moviesearch.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.policy.IntentPolicy
import com.gram15inch.moviesearch.R
import com.gram15inch.moviesearch.base.DataBindingActivity
import com.gram15inch.moviesearch.com.gram15inch.moviesearch.adapter.MovieAdapter
import com.gram15inch.moviesearch.databinding.ActivityMainBinding
import com.gram15inch.moviesearch.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
        binding.viewModel = viewModel
    }

    val movieClickListener: (Movie) -> Unit = {
        showToast(it.name)
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra(IntentPolicy.WEB_URL,it.url)
        startActivity(intent)
    }
}