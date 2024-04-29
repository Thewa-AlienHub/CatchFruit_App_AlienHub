package com.example.catchfruits

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import java.util.*

class MainActivityMedium : AppCompatActivity() {



    private var score = 0
    private var finalscore = 0
    private val allScoresText = null
    private var highScore = 0
    private val scores = mutableListOf<Int>()



    private val imageArray = ArrayList<ImageView>()
    private val handler = android.os.Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    private lateinit var tvTime: TextView
    private lateinit var tvScore: TextView
    private lateinit var ivApple: ImageView
    private lateinit var ivBanana: ImageView
    private lateinit var ivCherry: ImageView
    private lateinit var ivGrapes: ImageView
    private lateinit var ivKiwi: ImageView
    private lateinit var ivOrange: ImageView
    private lateinit var ivPear: ImageView
    private lateinit var ivStrawberry: ImageView
    private lateinit var ivWatermelon: ImageView






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        tvScore =findViewById(R.id.tvScore)
        tvTime = findViewById(R.id.tvTime)
        ivApple = findViewById(R.id.ivApple)
        ivBanana = findViewById(R.id.ivBanana)
        ivCherry = findViewById(R.id.ivCherry)
        ivGrapes = findViewById(R.id.ivGrapes)
        ivKiwi = findViewById(R.id.ivKiwi)
        ivOrange = findViewById(R.id.ivOrange)
        ivPear = findViewById(R.id.ivPear)
        ivStrawberry = findViewById(R.id.ivStrawberry)
        ivWatermelon = findViewById(R.id.ivWatermelon)

        tvScore.text = getString(R.string.score_0)
        score = 0
        imageArray.addAll(
            listOf(
                ivApple, ivBanana, ivCherry,
                ivGrapes, ivKiwi, ivOrange,
                ivPear, ivStrawberry, ivWatermelon
            )
        )


        hideImages()
        clickme()
        playAndRestart()
    }

    private fun hideImages() {
        runnable = Runnable {
            imageArray.forEach { it.visibility = View.INVISIBLE }
            imageArray[Random().nextInt(8)].visibility = View.VISIBLE
            handler.postDelayed(runnable, 600)
        }
        handler.post(runnable)
    }

    @SuppressLint("SetTextI18n")
    fun increaseScore() {
        score++
        tvScore.text= "Score : $score"

        if (score > highScore) {
            highScore = score
            // Optionally display High Score: (highScore)
        }
    }

    @SuppressLint("SetTextI18n")
    fun clickme() {
        // Inside onCreate or initialization method
        ivApple.setOnClickListener {
            increaseScore()
            ivApple.setImageResource(R.drawable.blast)



            // Reset ivApple2 to invisible after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivApple.setImageResource(R.drawable.apple)
            }, 1000) // Delay in milliseconds (adjust as needed)


        }

        ivBanana.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivBanana.setImageResource(R.drawable.blast)




            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivBanana.setImageResource(R.drawable.bananas) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
        ivCherry.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivCherry.setImageResource(R.drawable.blast)



            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivCherry.setImageResource(R.drawable.cherry) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
        ivGrapes.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivGrapes.setImageResource(R.drawable.blast)



            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivGrapes.setImageResource(R.drawable.grapes) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
        ivKiwi.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivKiwi.setImageResource(R.drawable.blast)



            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivKiwi.setImageResource(R.drawable.kiwi) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
        ivOrange.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivOrange.setImageResource(R.drawable.blast)



            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivOrange.setImageResource(R.drawable.orange) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
        ivPear.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivPear.setImageResource(R.drawable.blast)



            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivPear.setImageResource(R.drawable.pear) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
        ivStrawberry.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivStrawberry.setImageResource(R.drawable.blast)



            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivStrawberry.setImageResource(R.drawable.strawberry) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
        ivWatermelon.setOnClickListener{
            increaseScore()
            // Change the image resource
            ivWatermelon.setImageResource(R.drawable.blast)



            // Reset the image after a delay
            Handler(Looper.getMainLooper()).postDelayed({
                ivWatermelon.setImageResource(R.drawable.watermelon) // Reset to the original image
            }, 1000) // Delay in milliseconds (adjust as needed)
        }
    }




    @SuppressLint("SetTextI18n")
    fun playAndRestart() {
        score = 0
        tvScore.text = "Score : 0"
        hideImages()
        tvTime.text = "Time : 10"



// Construct the string to display all scores
        val builder = StringBuilder("All Scores:\n")
        for (score in scores) {
            builder.append("$score\n")
        }






        imageArray.forEach { it.visibility = View.INVISIBLE }

        object : CountDownTimer(20000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                tvTime.text = getString(R.string.time_up)
                scores
                handler.removeCallbacks(runnable)

                finalscore=score
                scores.add(finalscore)


                scores.sortDescending()
                val builder= StringBuilder("All Scores:\n")
                for (score in scores) {
                    builder.append("$score\n")
                }

                val allScoresText = builder.toString()


                val dialog = Dialog(this@MainActivityMedium)  // Create a Dialog instance


                val dialogView = layoutInflater.inflate(R.layout.dialogbox, null)

                dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.shapes))
                dialog.setContentView(dialogView)


                dialog.setCancelable(false)


                val tvScore = dialogView.findViewById<TextView>(R.id.tvScoreInDialog)
                val tvHighScore = dialogView.findViewById<TextView>(R.id.tvHighScoreInDialog)
                val tvAllScores = dialogView.findViewById<TextView>(R.id.tvAllScoresInDialog)
                val btnPlayAgain = dialogView.findViewById<Button>(R.id.btnPlayAgain)
                val btnExit = dialogView.findViewById<Button>(R.id.btnExit)


                tvScore.text = "Your score: $score"
                tvHighScore.text = "Your HighScore: $highScore"
                tvAllScores.text = allScoresText


                btnPlayAgain.setOnClickListener {
                    playAndRestart()
                    dialog.dismiss()
                }

                btnExit.setOnClickListener {

                    finalscore = score
                    score = 0
                    tvScore.text = "Score : 0"
                    tvTime.text = "Time : 0"
                    imageArray.forEach { it.visibility = View.INVISIBLE }
                    navigateToScoresActivity(highScore, finalscore, scores)
                    dialog.dismiss() // Dismiss the dialog when exit is clicked
                }


                dialog.show()
            }

            @SuppressLint("SetTextI18n")
            override fun onTick(tick: Long) {
                tvTime.text = "Time : " + tick / 1000
            }

            private fun navigateToScoresActivity(highScore:Int,currentScore: Int, allScoresList: MutableList<Int>) {
                val intent = Intent(this@MainActivityMedium, LastActivity::class.java)
                intent.putExtra("current_score", currentScore)

                // Convert MutableList<Int> to IntArray
                val allScoresArray = allScoresList.toIntArray()
                val allScoresString = allScoresArray.joinToString(separator = "\n")
                intent.putExtra("all_scores", allScoresString)

                val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                val currentHighScore = sharedPref.getInt("high_score", 0)
                if (currentScore > currentHighScore && currentScore > highScore) {
                    editor.putInt("high_score", currentScore)
                }else if(currentHighScore > highScore ){
                    editor.putInt("high_score", currentHighScore)
                }else{
                    editor.putInt("high_score", highScore)
                }

                // Store allScoresString in SharedPreferences
                editor.putString("all_scores", allScoresString)

                editor.apply()

                startActivity(intent)
            }


        }.start()
    }


}