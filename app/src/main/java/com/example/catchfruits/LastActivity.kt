package com.example.catchfruits

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class LastActivity : AppCompatActivity() {

    private lateinit var  tvHighScore: TextView
    private lateinit var  tvAllScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        tvHighScore = findViewById(R.id.highscoreteXt)
        tvAllScore = findViewById(R.id.allscoreText)

        val sharedPref = getSharedPreferences("my_prefs",Context.MODE_PRIVATE)

        val highScore = sharedPref.getInt("high_score",0)
        tvHighScore.text=" $highScore"

        val AllScoreString = sharedPref.getString("all_scores","")
        tvAllScore.text=AllScoreString
    }


     fun onClick(view: View) {

        when (view.id) {
            R.id.reastart -> {
                val intent = Intent(this, SecondMain::class.java)
                startActivity(intent)
            }
            R.id.end -> {
               finish()
            }

        }
    }


}