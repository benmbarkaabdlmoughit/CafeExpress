package com.example.projet2kotlinlayoute

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PersonnalisationCafeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnalisationcafe)

        val textirecafe:TextView = findViewById(R.id.Nomcafe)


        val typecafe = intent.getStringExtra("typecafe")

        textirecafe.text = typecafe
    }
}