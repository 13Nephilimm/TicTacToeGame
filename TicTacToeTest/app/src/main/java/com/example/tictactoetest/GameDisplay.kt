package com.example.tictactoetest

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class GameDisplay : AppCompatActivity(), View.OnClickListener {

    lateinit var b0 : Button
    lateinit var b1 : Button
    lateinit var b2 : Button
    lateinit var b3 : Button
    lateinit var b4 : Button
    lateinit var b5 : Button
    lateinit var b6 : Button
    lateinit var b7 : Button
    lateinit var b8 : Button
    private lateinit var menu : Button
//    var menu = findViewById(R.id.button2) as Button

    lateinit var tv : TextView

    var player1 = 0
    var player2 = 1
    var activeplayer = player1
    lateinit var filledpos : IntArray

    var gameActive = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_display)



        filledpos = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
        menu = findViewById(R.id.button2)


        b0 = findViewById(R.id.b0)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)

        b0.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
        menu.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }




    }

    override fun onClick(p0: View?) {

        if (!gameActive)
            return

        var btnClicked = findViewById<Button>(p0!!.id)
        var clickedTag = Integer.parseInt(btnClicked.tag.toString())

        if (filledpos[clickedTag] != -1)
            return

        filledpos[clickedTag] = activeplayer

        if (activeplayer == player1) {
            btnClicked.setText("0")
            activeplayer = player2
            btnClicked.setTextColor(Color.BLACK)
            btnClicked.backgroundTintList = getColorStateList(R.color.blue)

        } else {
        btnClicked.setText("X")
            activeplayer = player1
        btnClicked.setTextColor(Color.BLACK)
        btnClicked.backgroundTintList = getColorStateList(R.color.red) }

        checkForWin()

    }


    private fun checkForWin() {
        var winPos = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8),
            intArrayOf(0, 3, 6),
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(0, 4, 8),
            intArrayOf(2, 4, 6)
        )
        for (i in 0 until winPos.size) {
            var val0 = winPos[i][0]
            var val1 = winPos[i][1]
            var val2 = winPos[i][2]

            if (filledpos[val0] == filledpos[val1] && filledpos[val1] == filledpos[val2]) {
                if (filledpos[val0] != -1) {
                    gameActive = false
                    if (filledpos[val0] == player1) {
                        showMessage ("პირველმა მოთამაშემ გაიმარჯვა")
                    Toast.makeText(this, "პირველმა მოთამაშემ გაიმარჯვა", Toast.LENGTH_SHORT).show()
                } else {
                        showMessage ("მეორე მოთამაშემ გაიმარჯვა")
                    Toast.makeText(this, "მეორე მოთამაშემ გაიმარჯვა", Toast.LENGTH_SHORT).show()
                }
                    return
            }
        }

        }
        //draw
        var count = 0
        for(i in 0 until filledpos.size) {
            if(filledpos[i] == -1) {
                count++
            }
        }
        if (count == 0) {
            showMessage("ფრე")
            return
        }

    }


    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setPositiveButton("თავიდან დაწყება", DialogInterface.OnClickListener { dialog, which ->
                restartGame()
            })
            .show()

    }

    private fun restartGame() {
        filledpos = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
        activeplayer = player1
        gameActive = true
        b0.setText("")
        b1.setText("")
        b2.setText("")
        b3.setText("")
        b4.setText("")
        b5.setText("")
        b6.setText("")
        b7.setText("")
        b8.setText("")
        b0.backgroundTintList = getColorStateList(R.color.white)
        b1.backgroundTintList = getColorStateList(R.color.white)
        b2.backgroundTintList = getColorStateList(R.color.white)
        b3.backgroundTintList = getColorStateList(R.color.white)
        b4.backgroundTintList = getColorStateList(R.color.white)
        b5.backgroundTintList = getColorStateList(R.color.white)
        b6.backgroundTintList = getColorStateList(R.color.white)
        b7.backgroundTintList = getColorStateList(R.color.white)
        b8.backgroundTintList = getColorStateList(R.color.white)

    }

}


