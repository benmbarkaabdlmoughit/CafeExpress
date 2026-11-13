package com.example.projet2kotlinlayoute

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PersonnalisationtousmenuActivity : AppCompatActivity() {

    private lateinit var ButonCafe : Button
    private lateinit var ButonThe : Button
    private lateinit var ButonCroissant : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.personnaliser)

        ButonCafe = findViewById(R.id.ButonCafe)
        ButonThe = findViewById(R.id.ButonThe)
        ButonCroissant = findViewById(R.id.ButonCroissant)

        ButonCafe.setOnClickListener {
            var intent = Intent(this, personaliserchoisiedeCafe::class.java)

            startActivity(intent)
        }



    }
}