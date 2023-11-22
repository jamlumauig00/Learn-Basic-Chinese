package com.jam.cookingina.Database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import learn.basic.chinese.Database.ChineseViewModel

class ChineseViewModelFactory(private val repository: ChineseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChineseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ChineseViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}