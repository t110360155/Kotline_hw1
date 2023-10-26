package com.example.kotlin_hw1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var ed_name: EditText
    private lateinit var tv_text: TextView
    private lateinit var tv_name: TextView
    private lateinit var tv_winner: TextView
    private lateinit var tv_mmora: TextView
    private lateinit var tv_cmora: TextView
    private lateinit var btn_scissor: RadioButton
    private lateinit var btn_stone: RadioButton
    private lateinit var btn_paper: RadioButton
    private lateinit var btn_mora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ed_name = findViewById(R.id.ed_name)
        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)
        btn_mora = findViewById(R.id.btn_mora)
        btn_mora.setOnClickListener {
            //Determine whether the number of words in EditText is less than one.
            // If true, guessing will not be possible.
            if (ed_name.length() < 1) {
                tv_text.text = "Please Enter your name"
                return@setOnClickListener
            }
            //Take out the EditText text as the player name and store it in a variable
            val playerName = ed_name.text
            // Random numbers generate decimals between 0~1 without 1,
            // multiplied by 3 to become 0~2 as the computer's punch
            val comMora = (Math.random() * 3).toInt()
            //Correspond the player's punch results into strings and store them in variables
            val playerMoraText = when {
                btn_scissor.isChecked -> "Scissors"
                btn_stone.isChecked -> "Stone"
                else -> "Paper"
            }
            //Correspond the computer punch results into strings and store them with variables
            val comMoraText = when (comMora) {
                0 -> "Scissors"
                1 -> "Stone"
                else -> "Paper"
            }
            //Display player names and punch results of both parties
            tv_name.text = "Name\n$playerName"
            tv_mmora.text = "I throw\n$playerMoraText"
            tv_cmora.text = "Computer throws\n$comMoraText"
            //Use three judgments to determine the outcome and display the guessing results
            when {
                btn_scissor.isChecked && comMora == 2 ||
                        btn_stone.isChecked && comMora == 0 ||
                        btn_paper.isChecked && comMora == 1 -> {
                    tv_winner.text = "Winner is:\n$playerName"
                    tv_text.text = "Congratulations, you won！"
                }
                btn_scissor.isChecked && comMora == 1 ||
                        btn_stone.isChecked && comMora == 2 ||
                        btn_paper.isChecked && comMora == 0 -> {
                    tv_winner.text = "Winner is:\ncomputer"
                    tv_text.text = "What a pity, computer won！"
                }

                else -> {
                    tv_winner.text = "It's a draw\n"
                    tv_text.text = "It's a tie, please try again！"
                }
            }
        }
    }
}