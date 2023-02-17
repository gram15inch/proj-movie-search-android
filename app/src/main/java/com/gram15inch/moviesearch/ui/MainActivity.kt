package com.gram15inch.moviesearch.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.gram15inch.moviesearch.R
import com.gram15inch.moviesearch.base.DataBindingActivity
import com.gram15inch.moviesearch.databinding.ActivityMainBinding
import com.gram15inch.moviesearch.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :DataBindingActivity<ActivityMainBinding>(R.layout.activity_main){
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainTxt.text = viewModel.getTestString()
    }

}