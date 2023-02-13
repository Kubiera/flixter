package com.example.flixster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.example.flixster.R.id

class PlayingMoviesRecyclerViewAdapter (
    private val movies: List<PlayingMovie>,
    private val mListener: OnListFragmentInteractionListener?,
)
    : RecyclerView.Adapter<PlayingMoviesRecyclerViewAdapter.MovieViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_playing_movie, parent, false)
            return  MovieViewHolder(view)
        }

        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: PlayingMovie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.movieTitle) as TextView
            val mMovieDescription: TextView = mView.findViewById<View>(id.movieDescription) as TextView
            val mMovieImage: ImageView = mView.findViewById<View>(id.movieImage) as ImageView

        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movies[position]

            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieDescription.text = movie.description
            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500/" + movie.movieImage)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.notfound)
                .centerInside()
                .into(holder.mMovieImage)

            holder.mView.setOnClickListener {
                holder.mItem?.let { book ->
                    mListener?.onItemClick(book)
                }
            }
        }

        override fun getItemCount(): Int {
            return movies.size
        }
    }