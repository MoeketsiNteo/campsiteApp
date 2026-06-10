package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Transitioning to main screen after 3 seconds
        // Launch a coroutine tied to the Activity's lifecycle
        lifecycleScope.launch {
            delay(3000) // 3000 ms = 3 seconds
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            finish() // Close splash so user can't go back to it

        }
    }
}