package com.escolifesciences.myapplication.Controller

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.escolifesciences.myapplication.Model.Player
import com.escolifesciences.myapplication.R

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("player", player)
        Log.d("LifeCycle", player.toString())
    }

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

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable("player", Player::class.java)!!
            Log.d("LifeCycle", "test")
        }
    }

    fun onMensClick (view: View) {
        val btnWomens = findViewById<ToggleButton>(R.id.btnWomens)
        val btnCoEd = findViewById<ToggleButton>(R.id.btnCoEd)
        btnWomens.isChecked = false
        btnCoEd.isChecked = false
        player.league = "Mens"
    }

    fun onWomensClick (view: View) {
        val btnMens = findViewById<ToggleButton>(R.id.btnMens)
        val btnCoEd = findViewById<ToggleButton>(R.id.btnCoEd)
        btnMens.isChecked = false
        btnCoEd.isChecked = false
        player.league = "Womens"
    }

    fun onCoEdClick (view: View) {
        val btnMens = findViewById<ToggleButton>(R.id.btnMens)
        val btnWomens = findViewById<ToggleButton>(R.id.btnWomens)
        btnMens.isChecked = false
        btnWomens.isChecked = false
        player.league = "Co-Ed"
    }

    fun leagueNextClicked (view: View) {
        if (player.league != "" ) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra("player", player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "You haven't select the league", Toast.LENGTH_LONG).show()
        }

    }
}