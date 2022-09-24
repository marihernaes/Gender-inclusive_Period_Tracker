package com.example.gender_inclusiveperiodtracker.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * Factory for creating a [HistoryViewModel] with a constructor that takes an [EpisodeRepository].
 */
class HistoryViewModelFactory(
    private val repository: EpisodeRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HistoryViewModel(repository) as T
    }

}