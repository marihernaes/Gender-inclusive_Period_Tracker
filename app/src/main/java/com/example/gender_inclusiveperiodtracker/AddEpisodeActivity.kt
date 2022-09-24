package com.example.gender_inclusiveperiodtracker

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.gender_inclusiveperiodtracker.data.AppDatabase
import com.example.gender_inclusiveperiodtracker.data.Episode
import com.example.gender_inclusiveperiodtracker.databinding.ActivityAddItemBinding
import com.example.gender_inclusiveperiodtracker.utilities.InjectorUtils
import com.example.gender_inclusiveperiodtracker.utilities.TimeUtils.calculateDuration
import com.example.gender_inclusiveperiodtracker.utilities.TimeUtils.stringToDate
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * TODO: A start of implementing AddEntityActivity, using data binding instead!
 */

class AddEpisodeActivity : AppCompatActivity() {
    // class AddEpisodeActivity : AppCompatActivity(), DatePickerFragment.OnChosenDateListener {
/*
    private val viewModel: AddEpisodeViewModel by viewModels {
        InjectorUtils.provideAddPeriodViewModelFactory(context = this)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set up data binding automatically named in camelcase after xml in layout folder
        val binding: ActivityAddItemBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_add_item
        )
        binding.lifecycleOwner = this
    }


    // Inflate the menu options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_item_menu, menu)
        return true
    }

    // When "save" or "delete" is chosen in the options menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                // Save episode to database
                insertEpisode()
                // Exit activity
                finish()
                return true
            }
            R.id.action_delete -> {
                // Exit without saving
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertEpisode() {
        // TODO insert data from view
        val episodeDao = AppDatabase(this).episodeDao()
        // TODO remove globalcope
        GlobalScope.launch {
            episodeDao.insertOne(
                Episode(
                    stringToDate("01 Sep 2022"),
                    stringToDate("15 Sep 2022"),
                    calculateDuration(
                        stringToDate("01 Sep 2022"),
                        stringToDate("15 Sep 2022")),
                    28,
                    true,
                    false,
                    false,
                    2,
                    "test",
                    false)
            )
        }

        Toast.makeText(this, "Episode added!", Toast.LENGTH_SHORT).show()
    }
}