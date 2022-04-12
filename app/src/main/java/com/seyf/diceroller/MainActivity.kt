package com.seyf.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // R.<type>.<name>
        val rollButton: Button = findViewById(R.id.button)
        val rollText: TextView = findViewById(R.id.textView)
        val diceImage: ImageView = findViewById(R.id.imageView)

        fun rollDice() {
            val dice = Dice(6)
            val diceRoll = dice.roll()
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = diceRoll.toString()

            rollText.text = diceRoll.toString()
        }

        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }

        rollDice()

    }

}

class Dice (private val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()

    }
}
