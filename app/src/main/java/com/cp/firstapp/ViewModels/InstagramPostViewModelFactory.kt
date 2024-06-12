package com.cp.firstapp.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cp.firstapp.DataBase.InstagramPostRepository

class InstagramPostViewModelFactory(private val repository: InstagramPostRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InstagramPostViewModel::class.java)) {
            return InstagramPostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
