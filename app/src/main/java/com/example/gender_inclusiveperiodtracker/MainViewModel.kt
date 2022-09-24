package com.example.gender_inclusiveperiodtracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gender_inclusiveperiodtracker.data.Episode
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * The ViewModel used in [MainActivity].
 */
class MainViewModel(val episodeRepository: EpisodeRepository) : ViewModel() {
    // TODO ADD WHAT NEEDED
    val latestEpisode = episodeRepository.getLatestEpisode()
}