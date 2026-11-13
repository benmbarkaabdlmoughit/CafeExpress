package com.example.projet2kotlinlayoute

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class personnaliserCafe : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.personnalisationcafe)
        var rgTaille : RadioGroup = findViewById(R.id.rgTaille)
        var btncalculer : Button = findViewById(R.id.Calculer)

        var checsucr : CheckBox = findViewById(R.id.checsucr)
        var checCreme : CheckBox = findViewById(R.id.checCreme)
        var checCaramelle : CheckBox = findViewById(R.id.checCaramelle)
        val switchEmporte : SwitchCompat = findViewById(R.id.switchEmporte)
        val spinerLait : Spinner = findViewById(R.id.spinerLait)

        var resultat : TextView = findViewById(R.id.Prix)

        val Lait = listOf("Lait entier", "Lait écrémé", "Lait d'amande (+3 DH)", "Sans lait")
        val prixlait = listOf(0,0,3,0)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Lait)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinerLait.adapter = adapter


        btncalculer.setOnClickListener {
            val idtaille = rgTaille.checkedRadioButtonId
            val talle = when(idtaille){
                R.id.petite -> "petite"
                R.id.Moyen -> "Moyen"
                R.id.checCaramelle -> "Grand"
                else -> "aucan"
            }
            val Prixtaille = when(idtaille){
                R.id.petite -> 8
                R.id.Moyen -> 10
                R.id.Grand -> 12
                else -> 0
            }


            val supplements = mutableSetOf<String>()
            var prixsupliment = 0

            if(checsucr.isChecked){
                supplements.add("Sucre")
            }
            if(checCreme.isChecked){
                supplements.add("Creme")
                prixsupliment += 2
            }
            if(checCaramelle.isChecked){
                supplements.add("Caramelle")
                prixsupliment += 1
            }

            val emporter = if (switchEmporte.isChecked)
                2
            else
                0


            val position = spinerLait.selectedItemPosition
            val Prixlait = prixlait[position]
            val lait = spinerLait.selectedItem.toString()

            val prixtotal = Prixtaille + prixsupliment + Prixlait + emporter
            resultat.text = "Prix : $prixtotal DH"

            Toast.makeText(this, "$talle, ${supplements.joinToString(", ")}$emporter Position $position : $lait", Toast.LENGTH_SHORT).show()


        }




    }
}