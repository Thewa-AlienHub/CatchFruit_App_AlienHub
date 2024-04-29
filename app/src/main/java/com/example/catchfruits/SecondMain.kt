package com.example.catchfruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View



class SecondMain : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_main)





    }

    override fun onClick(view: View) {
        // Determine which button was clicked and start the corresponding activity
        when (view.id) {
            R.id.button1 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.button2 -> {
                val intent = Intent(this, MainActivityMedium::class.java)
                startActivity(intent)
            }
            R.id.button3 -> {
                val intent = Intent(this, MainActivityHard::class.java)
                startActivity(intent)
            }
        }
    }
}
