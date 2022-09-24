package com.example.gender_inclusiveperiodtracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * Factory for creating a [AddEpisodeViewModel] with a constructor that takes an [EpisodeRepository].
 */
class AddEpisodeViewModelFactory(
    private val repository: EpisodeRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddEpisodeViewModel(repository) as T
    }

}