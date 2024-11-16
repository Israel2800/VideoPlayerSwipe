package com.israelaguilar.videoplayerswipe

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.videoplayerswipe.databinding.ItemVideoBinding
import com.israelaguilar.videoplayerswipe.model.Video

class VideosAdapter(
    private val videos: MutableList<Video>
):RecyclerView.Adapter<VideosViewHolder>() {

    var isFav = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideosViewHolder(binding)
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.bind(videos[position])

        holder.ic_fav.setOnClickListener {
            isFav = !isFav
            val color = if(isFav) Color.RED else Color.WHITE
            holder.ic_fav.setColorFilter(color)
        }
    }


}