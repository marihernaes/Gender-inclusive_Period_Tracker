package com.example.gender_inclusiveperiodtracker.data

import androidx.room.*
import java.util.Date

/**
 * A table of an entity (as whole)
 * TODO divide into sub-database? Allow information about single days
 */
@Entity
data class Episode(
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "end_date") val endDate: Date,
    @ColumnInfo(name = "duration_days") val durationDays: Int? = null,
    @ColumnInfo(name = "cycle_days") val cycleDays: Int? = null,
    @ColumnInfo(name = "mood_happy") val moodHappy: Boolean = false,
    @ColumnInfo(name = "mood_neutral") val moodNeutral: Boolean = false,
    @ColumnInfo(name = "mood_sad") val moodSad: Boolean = false,
    // TODO Change to choose for single days
    // Flow: 1 is light, 2 is medium, 3 is heavy.
    @ColumnInfo(name = "episode_flow") val episodeFlow: Int,
    @ColumnInfo(name = "episode_notes") val episodeNotes: String,
    @ColumnInfo(name = "sick_leave") val sickLeave: Boolean
    ) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Long = 0
}

/*




@ColumnInfo(name = "med_buscopanplus") val medBuscopanPlus: Boolean,
@ColumnInfo(name = "med_buscopan") val medBuscopan: Boolean,
@ColumnInfo(name = "med_other") val medOther: Boolean,
@ColumnInfo(name = "dig_gas") val digGas: Boolean,
@ColumnInfo(name = "dig_bloating") val digBloating: Boolean,
@ColumnInfo(name = "dig_diarrhea") val digDiarrhea: Boolean,


*/