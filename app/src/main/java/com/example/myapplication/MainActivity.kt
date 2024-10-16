package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Variável para o número secreto
    private var numeroSecreto = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando a variável com um número aleatório entre 1 e 100
        numeroSecreto = Random.nextInt(1, 101)

        // Referências aos componentes da interface
        val resultadoText: TextView = findViewById(R.id.resultText)
        val userInput: EditText = findViewById(R.id.userInput)
        val guessButton: Button = findViewById(R.id.guessButton)

        // Configurando o evento de clique para o botão de adivinhar
        guessButton.setOnClickListener {
            val userGuess = userInput.text.toString().toIntOrNull()

            // Verificar se a entrada é válida
            if (userGuess == null) {
                Toast.makeText(this, "Por favor, insira um número válido", Toast.LENGTH_SHORT).show()
            } else {
                // Verificar a condição usando operadores relacionais
                when {
                    userGuess > numeroSecreto -> {
                        resultadoText.text = "Tente um número menor!"
                    }
                    userGuess < numeroSecreto -> {
                        resultadoText.text = "Tente um número maior!"
                    }
                    else -> {
                        resultadoText.text = "Parabéns! Você acertou!"
                        // Reinicia o jogo com um novo número secreto
                        numeroSecreto = Random.nextInt(1, 101)
                    }
                }
            }
        }
    }
}
