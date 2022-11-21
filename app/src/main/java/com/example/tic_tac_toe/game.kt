package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class game : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var reset: Button
    private lateinit var finish: Button
    private lateinit var player_1: TextView
    private lateinit var player_2: TextView
    private lateinit var score1: TextView
    private lateinit var score2: TextView




    private var activePLayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        init()
        player_1 = findViewById(R.id.player_1)
        player_2 = findViewById(R.id.player_2)

        player_1.text = intent.extras?.getString("firstPlayer")
        player_2.text = intent.extras?.getString("secondPlayer")

        reset.setOnClickListener() {
            firstPlayer.clear()
            secondPlayer.clear()
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            activePLayer = 1

            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true

            button1.setBackgroundColor(Color.rgb(2, 8,113))
            button2.setBackgroundColor(Color.rgb(2, 8,113))
            button3.setBackgroundColor(Color.rgb(2, 8,113))
            button4.setBackgroundColor(Color.rgb(2, 8,113))
            button5.setBackgroundColor(Color.rgb(2, 8,113))
            button6.setBackgroundColor(Color.rgb(2, 8,113))
            button7.setBackgroundColor(Color.rgb(2, 8,113))
            button8.setBackgroundColor(Color.rgb(2, 8,113))
            button9.setBackgroundColor(Color.rgb(2, 8,113))

        }

        finish.setOnClickListener() {

            val player1 = player_1.text.toString()
            val player2 = player_2.text.toString()

            val intent = Intent(this, finish::class.java)
            if(score1.text.toString() > score2.text.toString()) {
                intent.putExtra("finish", player1)
            }else if (score1.text.toString() < score2.text.toString()) {
                intent.putExtra("finish", player2)
            }
            startActivity(intent)


        }





    }


    private fun init(){
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)
        finish = findViewById(R.id.finish)

        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        reset.setOnClickListener(this)
        finish.setOnClickListener(this)

    }


    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0

            when(clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }

            if (buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePLayer == 1 ) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.WHITE)
            activePLayer = 2
            firstPlayer.add(buttonNumber)

        }else if (activePLayer == 2){
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.BLUE)
            activePLayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()




    }
    var player1score = 0
    var player2score = 0
    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if(secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer == 1) {
            Toast.makeText(this, "SLayy, X is a winner", Toast.LENGTH_SHORT).show()
            player1score ++

            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        if (winnerPlayer == 2) {
            Toast.makeText(this, "SLayy, 0 is a winner", Toast.LENGTH_SHORT).show()
            player2score ++

            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }

        if (firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0 ) {
            Toast.makeText(this, "gaimarjva megobrobam", Toast.LENGTH_SHORT).show()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
        score1.text = player1score.toString()
        score2.text = player2score.toString()


    }


}