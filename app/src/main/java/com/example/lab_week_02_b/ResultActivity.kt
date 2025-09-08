package com.example.lab_week_02_b

import android.os.Bundle
import android.graphics.Color
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ResultActivity : AppCompatActivity() {
    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val colorCode = intent.getStringExtra(COLOR_KEY)
        val background = findViewById<ConstraintLayout>(R.id.background_screen)
        val resultText = findViewById<TextView>(R.id.color_code_result_message)

        background.setBackgroundColor(Color.parseColor("#$colorCode"))
        resultText.text = "Color code #$colorCode is applied!"
    }
}
