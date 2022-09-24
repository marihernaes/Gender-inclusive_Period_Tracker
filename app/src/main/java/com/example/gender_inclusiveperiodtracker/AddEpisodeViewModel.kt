package com.example.gender_inclusiveperiodtracker

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.gender_inclusiveperiodtracker.data.EpisodeRepository

/**
 * TODO: A start of implementing AddEntityActivity, using data binding instead!
 */

/**
 * A ViewModel that is also an Observable,
 * to be used with the Data Binding Library.
 */

class AddEpisodeViewModel(val episodeRepository: EpisodeRepository) : BaseObservable()  {
    // TODO add stuff.. REMEMBER: if the binding does not show up you might need to recompile

    @get:Bindable
    var sickDay = false
        set(value) {
            field = value
            //notifyPropertyChanged(BR.sickDay)
        }


}