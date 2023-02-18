package com.gram15inch.moviesearch.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.gram15inch.domain.model.RecentSearch
import com.gram15inch.domain.policy.ExtraPolicy
import com.gram15inch.moviesearch.R
import com.gram15inch.moviesearch.base.DataBindingActivity
import com.gram15inch.moviesearch.databinding.ActivityRecentSearchBinding
import com.gram15inch.moviesearch.viewmodel.RecentSearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentSearchActivity :
    DataBindingActivity<ActivityRecentSearchBinding>(R.layout.activity_recent_search) {
    private val viewModel: RecentSearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
        binding.viewModel = viewModel
    }

    val recentSearchClickListener: (RecentSearch) -> Unit = {
        intent.putExtra(ExtraPolicy.RECENT_SEARCH,it.title)
        setResult(RESULT_OK,intent)
        finish()
    }
}