package com.example.gender_inclusiveperiodtracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * Factory for creating a [MainViewModel] with a constructor that takes an [EpisodeRepository].
 */
class MainViewModelFactory(
    private val repository: EpisodeRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}