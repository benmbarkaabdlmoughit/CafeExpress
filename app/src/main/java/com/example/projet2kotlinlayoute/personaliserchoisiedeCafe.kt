package com.example.projet2kotlinlayoute

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class personaliserchoisiedeCafe : AppCompatActivity() {

    private lateinit var butoncafeEspress : ImageButton
    private lateinit var imagCappuccino : ImageButton
    private lateinit var imageCafeLatte : ImageButton
    private lateinit var imageAmericano : ImageButton
    private lateinit var imageCafeGlace : ImageButton
    private lateinit var imageMocha : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personalisertypedecafe)

        butoncafeEspress = findViewById(R.id.butoncafe1Espress)
        imagCappuccino = findViewById(R.id.imagCappuccino)
        imageCafeLatte = findViewById(R.id.imageCaféLatte)
        imageAmericano = findViewById(R.id.imageAmericano)
        imageCafeGlace = findViewById(R.id.imageCaféGlacé)
        imageMocha = findViewById(R.id.imageMocha)

        butoncafeEspress.setOnClickListener{
            ouvrirPersonnalisation("Espresso ")
        }
        imagCappuccino.setOnClickListener {
            ouvrirPersonnalisation("Cappuccino")
        }
        imageCafeLatte.setOnClickListener {
            ouvrirPersonnalisation("Latte")
        }
        imageAmericano.setOnClickListener {
            ouvrirPersonnalisation("Americano")
        }
        imageCafeGlace.setOnClickListener {
            ouvrirPersonnalisation("Glace")
        }
        imageMocha.setOnClickListener {
            ouvrirPersonnalisation("Mocha")
        }

    }
    private fun ouvrirPersonnalisation(typecafe : String){
        val intent = Intent(this, PersonnalisationCafeActivity::class.java)
        intent.putExtra("typecafe" , typecafe)
        startActivity(intent)
    }
}