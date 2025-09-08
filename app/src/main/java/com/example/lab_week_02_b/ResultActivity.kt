package com.example.lab_week_02_b

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorInt

class ResultActivity : AppCompatActivity() {
    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
        private const val ERROR_KEY = "ERROR_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val colorCode = intent.getStringExtra(COLOR_KEY)
        val background = findViewById<ConstraintLayout>(R.id.background_screen)
        val resultText = findViewById<TextView>(R.id.color_code_result_message)

        try {
            background.setBackgroundColor(("#$colorCode").toColorInt())
            resultText.text = getString(R.string.color_code_result_message, colorCode?.uppercase())
        } catch (_: IllegalArgumentException) {
            val errorIntent = Intent()
            errorIntent.putExtra(ERROR_KEY, true)
            setResult(Activity.RESULT_OK, errorIntent)
            finish()
        }

        findViewById<Button>(R.id.back_button).setOnClickListener {
            finish()
        }
    }
}
