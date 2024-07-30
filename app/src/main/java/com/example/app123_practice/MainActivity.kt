package com.example.app123_practice

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {

    // carrossel

    private lateinit var carrosel : ViewPager
    private val handler = android.os.Handler(Looper.getMainLooper())
    private var currentPage = 0

    // menu
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // carrossel
        carrosel = findViewById(R.id.carrossel)

        // menu
        drawerLayout = findViewById(R.id.main)
        val navView = findViewById<NavigationView>(R.id.navView)
        val menu = findViewById<ImageView>(R.id.menuMain)

        // menu lógica
        menu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()

            when (menuItem.itemId) {
                R.id.homeMain -> {
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                }
                R.id.configPage -> {
                    startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
                }
                R.id.contatoPage -> {
                    startActivity(Intent(this@MainActivity, ContatoAcvtivity::class.java))
                }
                R.id.wsPage -> {
                    startActivity(Intent(this@MainActivity, WorldskillsActivity::class.java))
                }
                R.id.logoutPage -> {
                    startActivity(Intent(this@MainActivity, CadastroActivity::class.java))
                }
                R.id.loginPage -> {
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                }
            }

            true
        }
        // carrossel

        updateAutoScroll()
        updateCarrossel()


    }
    // onBack do menu

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    // atualiza carrossel

    private fun updateCarrossel() {

        val images = listOf(R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4)
        carrosel.adapter = CarrosselAdapter(images)

    }

    // atualiza carrossel

    private fun updateAutoScroll() {
        val update = Runnable {
            if (currentPage == (carrosel.adapter?.count?: 1) -1 ) {
                currentPage = 0
            }else{
                currentPage++
            }
            carrosel.setCurrentItem(currentPage, true)
        }

        handler.postDelayed(object : Runnable {
            override fun run() {
                update.run()
                handler.postDelayed(this, 3000)
            }
        },3000)

    }

    // corta carrossel

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}