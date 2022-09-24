package com.example.gender_inclusiveperiodtracker.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gender_inclusiveperiodtracker.data.Episode
import com.example.gender_inclusiveperiodtracker.utilities.TimeUtils.dateToString
import com.example.gender_inclusiveperiodtracker.databinding.ListItemEpisodeBinding

/**
 * Adapter for the [RecyclerView] of episodes.
 */
class EpisodeAdapter : ListAdapter<Episode, RecyclerView.ViewHolder>(
    EpisodeDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EpisodeViewHolder(
            ListItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val episode = getItem(position)
        (holder as EpisodeViewHolder).bind(episode)
    }

    // Provide a reference to the views for each data item
    class EpisodeViewHolder(
        private val binding: ListItemEpisodeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        /**
        init {
            binding.setClickListener {
                binding.run { episodeRepository.deleteOne(episodeRepository.getLatestEpisode()) }
            }
        }*/

        fun bind(item: Episode) {
            binding.apply {
                executePendingBindings()
                // Quick and dirty! Show the int as a string in the layout
                epCycle = if (item.cycleDays == null) {
                    "-"
                } else {
                    val suffix = if (item.cycleDays == 1) " day" else " days"
                    item.cycleDays.toString() + suffix
                }

                // Convert the rest of the information to string or proper types
                epTimeInterval = dateToString(item.startDate) + " - " + dateToString(item.endDate)
                // TODO add again epNotes = item.episodeNotes.trim()
            }
        }
    }
}

private class EpisodeDiffCallback : DiffUtil.ItemCallback<Episode>() {

    override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem == newItem
    }
}