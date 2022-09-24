package com.example.gender_inclusiveperiodtracker.ui.today

import androidx.lifecycle.ViewModel
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * The ViewModel used in [TodayFragment].
 */
class TodayViewModel(val episodeRepository: EpisodeRepository) : ViewModel() {

    val numElements = episodeRepository.getCount()
    val avgCycle = episodeRepository.getAverageCycle()
    val episodeWithLastStart = episodeRepository.getLatestLiveEpisode()
}