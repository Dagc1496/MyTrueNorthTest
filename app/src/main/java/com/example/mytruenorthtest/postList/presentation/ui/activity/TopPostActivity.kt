package com.example.mytruenorthtest.postList.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mytruenorthtest.databinding.ActivityTopPostBinding
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.presentation.ui.adapter.TopAdapter
import com.example.mytruenorthtest.postList.presentation.viewModel.TopViewModel
import com.example.mytruenorthtest.postList.presentation.viewModel.UpdatePostStateViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class TopPostActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTopPostBinding
    private lateinit var topAdapter: TopAdapter
    private val topViewModel: TopViewModel by viewModels()
    private val updatePostStateViewModel: UpdatePostStateViewModel by viewModels()

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
            topAdapter.refresh()
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
        if(error){
            binding.editTextErrorMessage.visibility = View.VISIBLE
            binding.progressBarLoader.isVisible = false
            binding.swipeRefreshTopPost.visibility = View.GONE
        }else{
            binding.editTextErrorMessage.visibility = View.GONE
            binding.swipeRefreshTopPost.visibility = View.VISIBLE
        }
    }

    private fun changePostState(post: Post){
        updatePostStateViewModel.updatePostState(post)
        topAdapter.notifyDataSetChanged()
    }

    private fun showImagePreview(thumbnail: String){
        val intent = Intent(this, ImagePreviewActivity::class.java).apply{
            putExtra("thumbnail", thumbnail)
        }
        startActivity(intent)
    }
}