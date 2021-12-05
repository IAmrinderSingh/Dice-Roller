package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        val dice1 =Dice(6)
        val diceRoll = dice.roll()
        val diceRoll1=dice.roll()
        // Update the screen with the dics roll
        val resultTextView: TextView = findViewById(R.id.textView)
        val resultTextView1: TextView =findViewById(R.id.textView1)
        resultTextView.text = diceRoll.toString()
        resultTextView1.text=diceRoll1.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}