package com.jinvita.mysoundplayer

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jinvita.mysoundplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer1: MediaPlayer
    private lateinit var mediaPlayer2: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeMediaPlayer()

        binding.buttonOne.setOnClickListener { playOrPauseAudio1() }
        binding.buttonTwo.setOnClickListener { playOrPauseAudio2() }
    }

    private fun initializeMediaPlayer() {
        mediaPlayer1 = MediaPlayer.create(this, R.raw.sample1)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.sample2)
        mediaPlayer1.setOnCompletionListener { binding.buttonOne.text = "1번 재생 완료" }
        mediaPlayer2.setOnCompletionListener { binding.buttonTwo.text = "2번 재생 완료" }
    }

    private fun playOrPauseAudio1() {
        if (mediaPlayer1.isPlaying) {
            mediaPlayer1.pause()
            binding.buttonOne.text = "1번 일시 정지"
        } else {
            mediaPlayer1.start()
            binding.buttonOne.text = "1번 재생 중"
        }

    }


    private fun playOrPauseAudio2() {
        if (mediaPlayer2.isPlaying) {
            mediaPlayer2.stop()
            mediaPlayer2.prepare()
            binding.buttonTwo.text = "2번 정지"
        } else {
            mediaPlayer2.start()
            binding.buttonTwo.text = "2번 재생 중"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer1.release()
        mediaPlayer2.release()
    }
}