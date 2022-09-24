package com.example.gender_inclusiveperiodtracker.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository
import com.example.gender_inclusiveperiodtracker.ui.profile.ProfileViewModel

/**
 * Factory for creating a [ProfileViewModel] with a constructor that takes an [EpisodeRepository].
 */
class ProfileViewModelFactory(
    private val repository: EpisodeRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}