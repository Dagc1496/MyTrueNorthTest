package com.example.mytruenorthtest.postList.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mytruenorthtest.common.extension.showSnackBar
import com.example.mytruenorthtest.databinding.ActivityTopPostBinding
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.presentation.ui.adapter.TopAdapter
import com.example.mytruenorthtest.postList.presentation.viewModel.TopViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class TopPostActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTopPostBinding
    private lateinit var topAdapter: TopAdapter
    private val topViewModel: TopViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configLoadStates()
        configAdapter()
        configRecyclerView()
        fetchTopList()
    }

    private fun configLoadStates(){
        binding.swipeRefreshTopPost.setOnRefreshListener {
            fetchTopList()
            binding.swipeRefreshTopPost.isRefreshing = false
        }
    }

    private fun configAdapter() {
        topAdapter = TopAdapter({post ->
            changePostState(post)
        },{thumbnail ->
            showImagePreview(thumbnail)
        })
        lifecycleScope.launchWhenStarted {
            with(topAdapter){

                loadStateFlow.collectLatest {
                    setLoadState(it.source.refresh is LoadState.Loading)
                    setErrorState(it.source.refresh is LoadState.Error)
                }
            }
        }
    }

    private fun configRecyclerView() {
        binding.recyclerViewTopPost.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = topAdapter
        }
    }

    private fun fetchTopList(){
        lifecycleScope.launchWhenStarted {
            topViewModel.fetchTopPage().collectLatest {
                topAdapter.submitData(it)
            }
        }
    }

    private fun setLoadState(isLoading: Boolean){
        binding.progressBarLoader.isVisible = isLoading
        binding.recyclerViewTopPost.isVisible = !isLoading
    }

    private fun setErrorState(error: Boolean) {
        binding.progressBarLoader.isVisible = !error
        binding.recyclerViewTopPost.isVisible = !error
    }

    private fun changePostState(post: Post){
        showSnackBar(binding.root, post.author)
    }

    private fun showImagePreview(thumbnail: String){
        val intent = Intent(this, ImagePreviewActivity::class.java).apply{
            putExtra("thumbnail", thumbnail)
        }

        startActivity(intent)
    }
}