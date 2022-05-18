package com.example.tictactoetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var play_button = findViewById(R.id.button) as Button

        play_button.setOnClickListener {
            val intent = Intent(this, PlayerSetup::class.java)
            startActivity(intent)
            }



        }
           }


