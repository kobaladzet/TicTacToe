package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var player1: EditText
    private lateinit var player2: EditText
    private lateinit var startButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)
        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener() {
            val firstPlayer = player1.text.toString()
            val secondPlayer = player2.text.toString()
            var start = startButton.text.toString()

            if (firstPlayer == "" || secondPlayer == "") {
                Toast.makeText(this, "შეიყვანეთ მოთამაშეების სახელები", Toast.LENGTH_SHORT).show()
            }else {
                intent = Intent(this, game::class.java)
                intent.putExtra("1Player", firstPlayer)
                intent.putExtra("2Player", secondPlayer)
                startActivity(intent)
            }






        }







    }




}