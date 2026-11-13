
package com.example.projet2kotlinlayoute
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn1: ImageButton
    private lateinit var btn2: ImageButton
    private lateinit var btn3: ImageButton
    private lateinit var btn4: ImageButton
    private lateinit var btn5: ImageButton
    private lateinit var btn6: ImageButton
    private lateinit var quntite1: TextView
    private lateinit var quntite2: TextView
    private lateinit var quntite3: TextView
    private lateinit var editnom: EditText
    private lateinit var total: TextView
    private lateinit var btnvider: Button
    private lateinit var btncommander: Button
    private lateinit var Personnaliser : Button


    private val prixcafe = 10.0
    private val prixthe = 8.0
    private val prixcroissent = 6.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.constraintlayout_cafeexpres)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        quntite1 = findViewById(R.id.quntite1)
        quntite2 = findViewById(R.id.quntite2)
        quntite3 = findViewById(R.id.quntite3)
        editnom = findViewById(R.id.editnom)
        btncommander = findViewById(R.id.btncommander)
        btnvider = findViewById(R.id.btnvider)
        total = findViewById(R.id.total)
        Personnaliser = findViewById(R.id.Personnaliser)


        btn(btn1, btn2, quntite1)
        btn(btn3, btn4, quntite2)
        btn(btn5, btn6, quntite3)

        Personnaliser.setOnClickListener {
            val q1 = quntite1.text.toString().toIntOrNull() ?: 0
            val q2 = quntite2.text.toString().toIntOrNull() ?: 0
            val q3 = quntite3.text.toString().toIntOrNull() ?: 0

            if (q1 > 0 || q2 > 0 || q3 > 0) {
                val intent = Intent(this, PersonnalisationtousmenuActivity::class.java)



                startActivity(intent)

            } else {
                Toast.makeText(
                    this,
                    "Choisissez au moins un produit",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        btncommander.setOnClickListener {
            val nom = editnom.text.toString().trim()

            if (nom.isEmpty()) {
                editnom.error = "Le nom est obligatoire"
                editnom.requestFocus()

            }  else {
                val intent = Intent(this, ActivitzAfichinfoActivity::class.java)
                intent.putExtra("nom", nom)
                intent.putExtra("Cafe", quntite1.text.toString().toIntOrNull() ?: 0 )
                intent.putExtra("the", quntite2.text.toString().toIntOrNull() ?: 0)
                intent.putExtra("Croissant", quntite3.text.toString().toIntOrNull() ?: 0)
                intent.putExtra("Total", calculertotal().toInt())

                startActivity(intent)
            }
        }



        btnvider.setOnClickListener {

            quntite1.text = "0"
            quntite2.text = "0"
            quntite3.text = "0"

            editnom.text.clear()
            editnom.error = null

            afichtotal()
        }


        afichtotal()
    }


    private fun btn(btnMion :ImageButton, btnplus : ImageButton,texteQuantite: TextView, quntitiinitial : Int = 0) {
        var quantiti = quntitiinitial

        btnMion.setOnClickListener {
            if (quantiti > 0){
                quantiti--
            }
            texteQuantite.text = quantiti.toString()
            afichtotal()
        }
        btnplus.setOnClickListener {
            quantiti++
            texteQuantite.text = quantiti.toString()
            afichtotal()
        }

    }

    private fun calculertotal(): Double {
        val q1 = quntite1.text.toString().toIntOrNull() ?: 0
        val q2 = quntite2.text.toString().toIntOrNull() ?: 0
        val q3 = quntite3.text.toString().toIntOrNull() ?: 0
        return (q1 * prixcafe) +
                (q2 * prixthe) +
                (q3 * prixcroissent)

    }

    private fun afichtotal() {
        total.setText("Total: ${calculertotal()} DH")
    }
}
