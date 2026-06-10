package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        //Connecting UI
        val textViewResults = findViewById<TextView>(R.id.textViewResults)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        val buttonExit = findViewById<Button>(R.id.buttonExit)

        //Receiving data from Main activity
        val viewList = intent.getStringExtra("LIST")

        //DISPLAYING OUTPUT
        textViewResults.text = viewList


        //Back to base button
        buttonBack.setOnClickListener {
            finish()
        }

        //Exit Application button
        buttonExit.setOnClickListener {
            finishAffinity()
        }

    }
}