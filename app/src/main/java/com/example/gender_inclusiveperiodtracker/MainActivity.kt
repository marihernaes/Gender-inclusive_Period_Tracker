package com.example.gender_inclusiveperiodtracker

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gender_inclusiveperiodtracker.databinding.ActivityMainBinding
import com.example.gender_inclusiveperiodtracker.utilities.InjectorUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * The Main Activity, initialized using data binding
 * from earlier project
 */
class MainActivity() : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels {
        InjectorUtils.provideMainViewModelFactory(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        // Set up data binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        // Set up bottom navigation menu
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navView: BottomNavigationView = binding.navView
        // val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_today, R.id.navigation_history, R.id.navigation_profile
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Set up fab
        binding.fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddEpisodeActivity::class.java)
            startActivity(intent)
        })
    }

    /**
     * Methods for the options menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        menuInflater.inflate(R.menu.top_options_menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // User clicked on a menu option in the app bar overflow menu
        when (item.itemId) {
            R.id.action_recompute_cycles -> {
                recomputeCycles()
                return true
            }
            // TODO RENAME ACTION TO SHOW THAT YOU ONLY DELETE ONE ACTION,
            //  THE ONE WHICH IS MOST RECENT IN TIME
            R.id.action_delete -> {
                deleteLast()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteLast() {
        // Co-routine on main
        // TODO RESEARCH AND FIND OTHER SOLUTION THAN GLOBAL SCOPE..
        GlobalScope.launch{
            viewModel.episodeRepository.deleteOne(viewModel.latestEpisode)
        }
    }

    private fun recomputeCycles() {
        GlobalScope.launch {
            viewModel.episodeRepository.recomputeAllCycles()
        }
    }

}