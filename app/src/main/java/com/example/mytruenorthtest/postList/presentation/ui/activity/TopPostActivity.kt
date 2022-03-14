package com.example.mytruenorthtest.postList.presentation.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mytruenorthtest.databinding.ActivityTopPostBinding
import com.example.mytruenorthtest.postList.presentation.ui.adapter.TopAdapter
import com.example.mytruenorthtest.postList.presentation.viewModel.TopViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class TopPostActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTopPostBinding
    private val topViewModel: TopViewModel by viewModels()

    @Inject
    lateinit var topAdapter: TopAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configLoadStates()
        configRecyclerView()
        configAdapter()
        fetchTopList()
    }

    private fun configRecyclerView() {
        binding.recyclerViewTopPost.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = topAdapter
        }
    }

    private fun configAdapter() {
        lifecycleScope.launchWhenStarted {
            with(topAdapter){

                loadStateFlow.collectLatest {
                    setLoadState(it.source.refresh is LoadState.Loading)
                }
            }
        }
    }

    private fun fetchTopList(){
        lifecycleScope.launchWhenStarted {
            topViewModel.fetchTopPage().collectLatest {
                topAdapter.submitData(it)
            }
        }
    }

    private fun configLoadStates(){
        binding.swipeRefreshTopPost.setOnRefreshListener {
            fetchTopList()
            binding.swipeRefreshTopPost.isRefreshing = false
        }
    }

    private fun setLoadState(isLoading: Boolean){
        binding.progressBarLoader.isVisible = isLoading
        binding.recyclerViewTopPost.isVisible = !isLoading
    }
}