package com.escolifesciences.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_league)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun onMensClick (view: View) {
        val btnWomens = findViewById<ToggleButton>(R.id.btnWomens)
        val btnCoEd = findViewById<ToggleButton>(R.id.btnCoEd)
        btnWomens.isChecked = false
        btnCoEd.isChecked = false
        selectedLeague = "Mens"
    }

    fun onWomensClick (view: View) {
        val btnMens = findViewById<ToggleButton>(R.id.btnMens)
        val btnCoEd = findViewById<ToggleButton>(R.id.btnCoEd)
        btnMens.isChecked = false
        btnCoEd.isChecked = false
        selectedLeague = "Womens"
    }

    fun onCoEdClick (view: View) {
        val btnMens = findViewById<ToggleButton>(R.id.btnMens)
        val btnWomens = findViewById<ToggleButton>(R.id.btnWomens)
        btnMens.isChecked = false
        btnWomens.isChecked = false
        selectedLeague = "Co-Ed"
    }

    fun leagueNextClicked (view: View) {
        if (selectedLeague != "" ) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra("selectedLeague", selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "You haven't select the league", Toast.LENGTH_LONG).show()
        }

    }
}