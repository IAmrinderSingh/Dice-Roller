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
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll1=dice.roll()
        // Update the screen with the dice roll
        val diceImage: ImageView =findViewById(R.id.imageView)
        val diceImage1:ImageView=findViewById((R.id.imageView2))

//      Find the Image View in layout
        fun drawableResources(any:Int): Int {return when(any){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        }
//      Determine Which drawable resource ID to use based on the dice roll
        diceImage.setImageResource(drawableResources(diceRoll))
        diceImage1.setImageResource(drawableResources(diceRoll1))

//      Update the content description
        diceImage.contentDescription=diceRoll.toString()
        diceImage1.contentDescription=diceRoll1.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}