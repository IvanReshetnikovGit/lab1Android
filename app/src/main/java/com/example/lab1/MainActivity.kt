package com.example.lab1

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView: TextView = findViewById(R.id.textView)
        Log.d("MainActivity", "Застосунок успішно запущено!")

        val seek: SeekBar = findViewById(R.id.seekBar)
        seek.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean){
                    textView.textSize = seek.progress.toFloat()
                }
                override fun onStartTrackingTouch(seek: SeekBar) {}
                override fun onStopTrackingTouch(seek: SeekBar) {}
            }
        )

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            textView.setTextColor(Color.HSVToColor(floatArrayOf((Math.random() * 360).toFloat(), 1f, 1f)))
        }

        val buttonChangeBack: Button = findViewById(R.id.button2)
        buttonChangeBack.setOnClickListener {
            val view: ConstraintLayout = findViewById(R.id.main)
            view.setBackgroundColor(Color.HSVToColor(floatArrayOf((Math.random() * 360).toFloat(), 1f, 1f)))
        }
        val name: EditText = findViewById(R.id.editTextText)
        name.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "hello ${name.text}", Toast.LENGTH_SHORT).show()
            }
        }
        val mainLayout: ConstraintLayout = findViewById(R.id.main)
        mainLayout.setOnClickListener {
            name.clearFocus()
        }

    }
}