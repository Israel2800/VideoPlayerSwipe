package com.israelaguilar.videoplayerswipe

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.videoplayerswipe.databinding.ItemVideoBinding
import com.israelaguilar.videoplayerswipe.model.Video

class VideosViewHolder(
    private val binding: ItemVideoBinding
):RecyclerView.ViewHolder(binding.root) {

    // La vista con el corazón de favoritos
    val ic_fav = binding.icFav

    fun bind(video: Video){

        binding.apply {

            tvVideoTitle.text = video.title
            tvVideoDescription.text = video.description

            vvVideo.setVideoPath(video.url)

            vvVideo.setOnPreparedListener { mediaPlayer ->
                pbVideo.visibility = View.GONE

                mediaPlayer.start()

                // Para no deformar el video
                // Obtenemos la proporción del video
                val videoRatio: Float = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()

                // Obtenemos la proporción de la pantalla
                val screenRatio: Float = vvVideo.width / vvVideo.height.toFloat()

                val scale = videoRatio / screenRatio

                // Asegurando que el video mantenga su relación de aspecto sin distorsión y ocupando todo el espacio posible
                if(videoRatio >= 1f) // El video es más ancho que la pantalla. Ajustamos el eje x
                    vvVideo.scaleX = scale
                else // El video es más alto que la pantalla
                    vvVideo.scaleY = 1f / scale

            }

            // Va a reproducir el video en un loop
            vvVideo.setOnCompletionListener { mediaPlayer ->
                mediaPlayer.start()
            }
        }
    }
}