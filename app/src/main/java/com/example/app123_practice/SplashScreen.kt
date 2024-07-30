package com.example.app123_practice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.animation.AnimationUtils

class SplashScreen : AppCompatActivity() {

    private val splashScreenStarted = 3000

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logo = findViewById<TextView>(R.id.logo)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
        },splashScreenStarted.toLong())
    }
}