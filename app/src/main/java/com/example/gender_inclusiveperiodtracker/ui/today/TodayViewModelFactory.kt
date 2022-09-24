package com.example.gender_inclusiveperiodtracker.ui.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * Factory for creating a [TodayViewModel] with a constructor that takes an [EpisodeRepository].
 */
class TodayViewModelFactory(
    private val repository: EpisodeRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodayViewModel(repository) as T
    }
}