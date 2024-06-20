package com.escolifesciences.myapplication.Controller

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.escolifesciences.myapplication.Model.Player
import com.escolifesciences.myapplication.R

class SkillActivity : AppCompatActivity() {

    lateinit var player : Player
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_skill)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        player = intent.getParcelableExtra("player", Player::class.java)!!
    }

    fun onBeginnerClick (view: View) {
        val btnBaller = findViewById<ToggleButton>(R.id.btnBaller)
        btnBaller.isChecked = false
        player.skill = "Beginner"
    }
    fun onBallerClick (view: View) {
        val btnBeginner = findViewById<ToggleButton>(R.id.btnBeginner)
        btnBeginner.isChecked = false
        player.skill = "Baller"
    }
    fun onFinishClick (view : View) {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra("player", player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please Select a skill level", Toast.LENGTH_LONG).show()
        }

    }
}