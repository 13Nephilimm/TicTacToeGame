package com.example.tictactoetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class PlayerSetup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player_setup)

        var submit = findViewById(R.id.button3) as Button
        var first_name = findViewById(R.id.editTextTextPersonName3) as TextView
        var second_name = findViewById(R.id.editTextTextPersonName4) as TextView


        submit.setOnClickListener() {
            val intent = Intent(this, GameDisplay::class.java)
            if (first_name.text.isEmpty() || second_name.text.isEmpty())
            { Toast.makeText(this, "გთხოვთ შეიყვანოთ მოთამაშეების სახელები", Toast.LENGTH_SHORT).show() }
            else { startActivity(intent) }
        }
    }
}