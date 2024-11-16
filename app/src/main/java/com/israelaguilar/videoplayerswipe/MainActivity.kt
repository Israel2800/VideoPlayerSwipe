package com.israelaguilar.videoplayerswipe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.videoplayerswipe.databinding.ActivityMainBinding
import com.israelaguilar.videoplayerswipe.model.Video

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        val videos = mutableListOf<Video>()

        val video1 = Video(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            "Big Buck Bunny",
            "Este corto cuenta la historia de un conejo gigante con un corazón más grande que él mismo."
        )
        videos.add(video1)

        val video2 = Video(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            "Elephant Dream",
            "La primera película hecha en Blender en 2006"
        )
        videos.add(video2)

        val video3 = Video(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            "We Are Going On Bullrun",
            "Rally en un Shelby GT500 del 2011"
        )
        videos.add(video3)

        // Instanciamos un adapter
        val videosAdapter = VideosAdapter(videos)

        // Le pasamos el adapter al ViewPager2
        binding.vpVideos.adapter = videosAdapter
    }
}