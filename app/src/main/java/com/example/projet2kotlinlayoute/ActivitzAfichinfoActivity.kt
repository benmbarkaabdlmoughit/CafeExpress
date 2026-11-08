package com.example.projet2kotlinlayoute

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitzAfichinfoActivity : AppCompatActivity() {

    private lateinit var modifier : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitz_afichinfo)

        val txtRecapClient: TextView = findViewById(R.id.Clien)
        val txtRecapcafe : TextView = findViewById(R.id.Cafe)
        val txtRecapThe : TextView = findViewById(R.id.The)
        val txtRecepCroissanat : TextView = findViewById(R.id.Croissant)
        val total : TextView = findViewById(R.id.total)

        modifier = findViewById(R.id.madifier)


        val nom = intent.getStringExtra("nom")
        val qntiteCafe = intent.getIntExtra("Cafe", 0 )
        val qntiteThe = intent.getIntExtra("the", 0)
        val qntiteCroisant = intent.getIntExtra("Croissant" , 0)
        val totale = intent.getIntExtra("Total", 0)





        txtRecapClient.text = "clien : $nom"
        txtRecapcafe.text = "Café : $qntiteCafe × 10 DH = ${qntiteCafe * 10} DH"
        txtRecapThe.text = "The : $qntiteThe × 10 DH = ${qntiteThe * 8} DH"
        txtRecepCroissanat.text = "Croissant : $qntiteCroisant × 10 DH = ${qntiteCroisant * 6} Dh"
        total.text = "Totale : $totale DH"


        modifier.setOnClickListener {
            finish()
        }

    }

}