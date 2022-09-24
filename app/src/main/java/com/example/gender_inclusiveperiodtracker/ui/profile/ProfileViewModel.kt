package com.example.gender_inclusiveperiodtracker.ui.profile

import androidx.lifecycle.ViewModel
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * The ViewModel used in [ProfileFragment].
 */
class ProfileViewModel(episodeRepository: EpisodeRepository) : ViewModel() {

    val liveEpisodeIds = episodeRepository.getAllByID()
}