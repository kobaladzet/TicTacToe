package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class finish : AppCompatActivity() {

    private lateinit var winner:TextView
    private lateinit var button:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        button = findViewById(R.id.button)

        winner = findViewById(R.id.winner)
        winner.text = intent.extras?.getString("finish")

        button.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}