package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            /**
            *best practice seen as this is only a one line function you can make it just one line
            *I have kept it this way because i wanted the toast code to remain
            */
            rollDice()

            /** - old code
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"
             */
        }

        //doing a rollDice() straightaway so that the initial image shown on startup will be random
        rollDice()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val diceOne = Dice(6)
        val diceTwo = Dice(6)
        val diceRoll = diceOne.roll()
        val diceRollTwo = diceTwo.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRollTwo.toString()

        // Determine which drawable resource ID to use based on the dice roll
        val drawableOne = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        val drawableTwo = when (diceRollTwo) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }


        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableOne)
        diceImage2.setImageResource(drawableTwo)

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}