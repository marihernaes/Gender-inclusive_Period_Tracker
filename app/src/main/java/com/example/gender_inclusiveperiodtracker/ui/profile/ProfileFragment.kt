package com.example.gender_inclusiveperiodtracker.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.gender_inclusiveperiodtracker.databinding.FragmentProfileBinding
import com.example.gender_inclusiveperiodtracker.utilities.InjectorUtils

/**
 * The MeFragment which shows the page with analysis and/or settings (in progress)
 */
class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels {
        InjectorUtils.provideMeViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // The binding is automatically named in camelcase after fragment_me.xml
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        context ?: return binding.root

        // TODO: ADD ANALYSIS, SETTINGS, POSSIBILITY TO SAVE THE DATABASE, ETC.
        binding.inProgress = "in progress"

        // TODO REMOVE simple stats of the data base
        viewModel.liveEpisodeIds.observe(viewLifecycleOwner, Observer {
            val message = if (it.isNotEmpty()) {
                "Entities in database: " + it.size.toString() + "\n Last episode added: " +
                        it.last().startDate.toString() + " " + it.last().id
            } else {
                "There are no entries yet."
            }
            binding.debugText = message
        })

        return binding.root
    }
}
