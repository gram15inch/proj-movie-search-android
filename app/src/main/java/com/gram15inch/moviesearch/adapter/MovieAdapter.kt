package com.gram15inch.moviesearch.com.gram15inch.moviesearch.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gram15inch.domain.model.Movie
import com.gram15inch.moviesearch.R
import com.gram15inch.moviesearch.databinding.LayoutHolderMovieBinding

class MovieAdapter(
    private val onItemClicked: (Movie) -> Unit,
    private val onLastPageListener: (Int) -> Unit
) :
    ListAdapter<Movie, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(
            LayoutHolderMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val current = getItem(position)
        (holder as MovieViewHolder).bind(current)
        if (position == currentList.size - 1)
            onLastPageListener(currentList.size + 10)
    }

    inner class MovieViewHolder(var binding: LayoutHolderMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun bind(res: Movie) {
            binding.apply {
                Glide.with(binding.root).load(res.thumbnail).error(R.drawable.tn_movie)
                    .into(holderMovieTnImg)
                //Glide.with(binding.root).load(R.drawable.tn_movie).into(holderMovieTnImg)
                val r = binding.root.context.resources

                holderMovieNameText.text = r.getString(R.string.holder_movie_name, res.name)
                holderMovieYearText.text = r.getString(R.string.holder_movie_release, res.release)
                holderMovieRateText.text = r.getString(R.string.holder_movie_rate, res.rating)
                holderContainer.setOnClickListener {
                    onItemClicked(res)
                }
            }
        }

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem

            }
        }
    }
}