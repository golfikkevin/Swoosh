package com.escolifesciences.myapplication.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.escolifesciences.myapplication.R

class SkillActivity : AppCompatActivity() {

    var league = ""
    var skill = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_skill)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        league = intent.getStringExtra("selectedLeague").toString()
    }

    fun onBeginnerClick (view: View) {
        val btnBaller = findViewById<ToggleButton>(R.id.btnBaller)
        btnBaller.isChecked = false
        skill = "Beginner"
    }
    fun onBallerClick (view: View) {
        val btnBeginner = findViewById<ToggleButton>(R.id.btnBeginner)
        btnBeginner.isChecked = false
        skill = "Baller"
    }
    fun onFinishClick (view : View) {
        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra("selectedLeague", league)
            finishActivity.putExtra("selectedSkill", skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please Select a skill level", Toast.LENGTH_LONG).show()
        }

    }
}