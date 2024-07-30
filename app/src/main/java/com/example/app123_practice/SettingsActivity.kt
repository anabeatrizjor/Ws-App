package com.example.app123_practice

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class SettingsActivity : AppCompatActivity() {

    // menu
    private lateinit var drawerLayout: DrawerLayout

    // switch notifications
    private lateinit var switchNotification: Switch
    private val NOTIFICATION_PERMISSION_REQUEST_CODE = 1

    // switch noturno
    private lateinit var switchNoturno: Switch
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // menu

        drawerLayout = findViewById(R.id.mainS)
        val navView = findViewById<NavigationView>(R.id.navViewSettings)
        val menu = findViewById<ImageView>(R.id.menuConfig)

        // notificações
        switchNotification = findViewById(R.id.switchNotifications)

        // noturno
        switchNoturno = findViewById(R.id.switchNightMode)
        sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)

        // LÓGICA MENU
        // menu lógica
        menu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()

            when (menuItem.itemId) {
                R.id.homeMain -> {
                    startActivity(Intent(this@SettingsActivity, MainActivity::class.java))
                }
                R.id.configPage -> {
                    startActivity(Intent(this@SettingsActivity, SettingsActivity::class.java))
                }
                R.id.contatoPage -> {
                    startActivity(Intent(this@SettingsActivity, ContatoAcvtivity::class.java))
                }
                R.id.wsPage -> {
                    startActivity(Intent(this@SettingsActivity, WorldskillsActivity::class.java))
                }
                R.id.logoutPage -> {
                    startActivity(Intent(this@SettingsActivity, CadastroActivity::class.java))
                }
                R.id.loginPage -> {
                    startActivity(Intent(this@SettingsActivity, LoginActivity::class.java))
                }
            }

            true
        }

        // noturno
        val isNightMode = sharedPreferences.getBoolean("night_mode", false)
        switchNoturno.isChecked = isNightMode
        nightMode(isNightMode)

        switchNoturno.setOnCheckedChangeListener { _, isChecked ->
            nightMode(isChecked)
            val editor = sharedPreferences.edit()
            editor.putBoolean("night_mode", isChecked)
            editor.apply()
        }

        // notifications

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(
                    android.Manifest.permission.POST_NOTIFICATIONS
                ), NOTIFICATION_PERMISSION_REQUEST_CODE)
            }
        }

        switchNotification.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }else{

            }
        }


    }

    // onBack do menu

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    // NOTURNO
    private fun nightMode (isNightMode: Boolean) {
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    // NOTIFICATIONS
    private fun areNotificationsEnabled() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.areNotificationsEnabled()
    }

    // Cancel notifications
    private fun cancelNotifications () {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancelAll()
    }

    // Permission Request
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == NOTIFICATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }else{

            }
        }
    }
}