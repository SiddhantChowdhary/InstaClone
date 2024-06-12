package com.cp.firstapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cp.firstapp.DataBase.InstagramPostRepository
import com.cp.firstapp.Models.InstagramPost
import kotlinx.coroutines.launch

class InstagramPostViewModel(private val repository: InstagramPostRepository) : ViewModel() {

    private val _posts = MutableLiveData<List<InstagramPost>>()
    val posts: LiveData<List<InstagramPost>> get() = _posts

    fun loadPosts() {
        viewModelScope.launch {
            val loadedPosts = repository.getPosts()
            _posts.postValue(loadedPosts)
        }
    }
}