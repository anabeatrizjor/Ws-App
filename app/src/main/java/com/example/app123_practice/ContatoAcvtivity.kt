package com.example.app123_practice

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class ContatoAcvtivity : AppCompatActivity() {

    private lateinit var drawerLayout : DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_acvtivity)


        drawerLayout = findViewById(R.id.mainC)
        val navView = findViewById<NavigationView>(R.id.navViewContato)
        val menu = findViewById<ImageView>(R.id.menuContato)

        menu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()

            when (menuItem.itemId) {
                R.id.homeMain -> {
                    startActivity(Intent(this@ContatoAcvtivity, MainActivity::class.java))
                }
                R.id.configPage -> {
                    startActivity(Intent(this@ContatoAcvtivity, SettingsActivity::class.java))
                }
                R.id.contatoPage -> {
                    startActivity(Intent(this@ContatoAcvtivity, ContatoAcvtivity::class.java))
                }
                R.id.wsPage -> {
                    startActivity(Intent(this@ContatoAcvtivity, WorldskillsActivity::class.java))
                }
                R.id.logoutPage -> {
                    startActivity(Intent(this@ContatoAcvtivity, CadastroActivity::class.java))
                }
                R.id.loginPage -> {
                    startActivity(Intent(this@ContatoAcvtivity, LoginActivity::class.java))
                }
            }

            true
        }

        // para puxar link para site
        val url = Uri.parse("https://worldskills.org/")
        startActivity(Intent(Intent.ACTION_VIEW, url))


    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}