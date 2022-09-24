package com.example.gender_inclusiveperiodtracker.utilities

import android.content.Context
import com.example.gender_inclusiveperiodtracker.AddEpisodeViewModelFactory
import com.example.gender_inclusiveperiodtracker.MainViewModelFactory
import com.example.gender_inclusiveperiodtracker.data.AppDatabase
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository
import com.example.gender_inclusiveperiodtracker.ui.profile.ProfileViewModelFactory
import com.example.gender_inclusiveperiodtracker.ui.history.HistoryViewModelFactory
import com.example.gender_inclusiveperiodtracker.ui.today.TodayViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    private fun getEpisodeRepository(context: Context): EpisodeRepository {
        return EpisodeRepository.getInstance(
            AppDatabase.invoke(context.applicationContext).episodeDao())
    }

    fun provideDisplayViewModelFactory(
        context: Context
    ): HistoryViewModelFactory {
        val repository = getEpisodeRepository(context)
        return HistoryViewModelFactory(repository)
    }

    fun provideHomeViewModelFactory(
        context: Context
    ): TodayViewModelFactory {
        val repository = getEpisodeRepository(context)
        return TodayViewModelFactory(repository)
    }

    fun provideMeViewModelFactory(
        context: Context
    ): ProfileViewModelFactory {
        val repository = getEpisodeRepository(context)
        return ProfileViewModelFactory(repository)
    }

    fun provideMainViewModelFactory(
        context: Context
    ): MainViewModelFactory {
        val repository = getEpisodeRepository(context)
        return MainViewModelFactory(repository)
    }

    fun provideAddEpisodeViewModelFactory(
        context: Context
    ): AddEpisodeViewModelFactory {
        val repository = getEpisodeRepository(context)
        return AddEpisodeViewModelFactory(repository)
    }
}