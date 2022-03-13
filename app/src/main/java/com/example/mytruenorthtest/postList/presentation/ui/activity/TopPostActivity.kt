package com.example.mytruenorthtest.postList.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytruenorthtest.R
import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.common.extension.showSnackBar
import com.example.mytruenorthtest.databinding.ActivityTopPostBinding
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.presentation.ui.adapter.TopAdapter
import com.example.mytruenorthtest.postList.presentation.viewModel.TopViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class TopPostActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTopPostBinding
    private val topViewModel: TopViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted {
            topViewModel.loader.collect(){
                setLoadingState(it)
            }
        }

        fetchTopList()
    }

    private fun fetchTopList() {
        topViewModel.fetchTopPage().observe(this){result ->
            result.fold(
                onSuccess = {   page ->
                    setupList(page)
                },
                onFailure = {
                    showSnackBar(binding.root ,getErrorMessage(it))
                }
            )
        }
    }

    private fun getErrorMessage(exception: Throwable) : String {
        if(exception is NoDataRecivedException){
            return resources.getString(R.string.unexpected_error)
        }
        else{
            return resources.getString(R.string.sorry_we_have_problems)
        }
    }

    private fun setupList(page: Page) {
        with(binding.recyclerViewTopPost){
            layoutManager = LinearLayoutManager(context)
            adapter = TopAdapter(page.postList)
        }
    }

    private fun setLoadingState(isLoading: Boolean) {
        binding.progressBarLoader.isVisible = isLoading
        binding.recyclerViewTopPost.isVisible = !isLoading
    }
}