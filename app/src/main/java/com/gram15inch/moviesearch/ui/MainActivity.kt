package com.gram15inch.moviesearch.ui

import android.content.Intent
import android.os.Bundle
import android.view.View.OnClickListener
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.policy.ExtraPolicy
import com.gram15inch.moviesearch.R
import com.gram15inch.moviesearch.base.DataBindingActivity
import com.gram15inch.moviesearch.databinding.ActivityMainBinding
import com.gram15inch.moviesearch.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var resultRecentSearchLauncher: ActivityResultLauncher<Intent>
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
        binding.viewModel = viewModel
        setResultRecentSearch()
    }

    val movieClickListener: (Movie) -> Unit = {
        showToast(it.name)
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra(ExtraPolicy.WEB_URL, it.url)
        startActivity(intent)
    }

    val lastPageListener: (Int) -> Unit = {
        viewModel.refreshMovie(it)
        showSnackBar("refresh $it")
    }

    val recentSearchClickListener = OnClickListener {
        val intent = Intent(this, RecentSearchActivity::class.java)
        resultRecentSearchLauncher.launch(intent)
    }
    private fun setResultRecentSearch(){
        resultRecentSearchLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == RESULT_OK){
                val recent = result.data?.getStringExtra(ExtraPolicy.RECENT_SEARCH) ?: ""
                viewModel.refreshRecentSearch(recent)
            }
        }
    }
}