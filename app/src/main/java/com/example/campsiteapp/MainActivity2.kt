package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //Connecting UI
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonList = findViewById<Button>(R.id.buttonList)
        val textViewTotalResults = findViewById<TextView>(R.id.textViewTotalResults)

        //Parallel Array
        val itemName = arrayOf("Tent", "Marshmallow", "Flashlight")
        val category = arrayOf("Shelter", "Food", "Safety")
        val quantity = arrayOf(1,3,2)
        val comments = arrayOf("4-person waterproof", "For S'mores (Mega size)", "Check batteries(AA)")

        //Calculating total items using Loop
        for (i in quantity.indices){
            var total = ""
            total += "&{quantity[i]}"
            textViewTotalResults.text ="TOTAL ITEMS PACKED: $total"
        }

        //Adding Gear button
        buttonAdd.setOnClickListener {
            //Pop up for message to show that gear added successfully
            Toast.makeText(this, "Gear added successfully!", Toast.LENGTH_SHORT
            ).show()
        }

        //Button to view List of items and gears on the next screen
        buttonList.setOnClickListener {
            var output = "CAMPING CHECKLIST"

            //Loop for adding items
            for (i in itemName.indices) {
                output +="ITEM NAME\t\t CATEGORY\t\t QUANTITY\t\t Comments\n"
                output +="-------------------------------------------------------------------------\n"
                output += "${itemName[i]}\t\t ${category[i]}\t\t ${quantity[i]}\t\t ${comments[i]}\n"
            }
            //opening the detailed view screen
            val intent = Intent(this, detailedView::class.java)


            //Sending data to detailed view screen
            intent.putExtra("LIST", output)

            startActivity(intent)
        }

    }

}