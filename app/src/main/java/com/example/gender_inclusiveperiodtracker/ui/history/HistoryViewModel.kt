package com.example.gender_inclusiveperiodtracker.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gender_inclusiveperiodtracker.data.Episode
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * The ViewModel used in [HistoryFragment].
 */
class HistoryViewModel(val episodeRepository: EpisodeRepository) : ViewModel() {
    val avgDuration = episodeRepository.getAverageDuration()
    val avgCycle = episodeRepository.getAverageCycle()
    val liveEpisodeIds : LiveData<List<Episode>> = episodeRepository.getAllLiveByDate()
}