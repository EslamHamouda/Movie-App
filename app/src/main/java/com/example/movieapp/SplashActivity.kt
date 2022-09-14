package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            goOnboarding()
        }, 3000)
    }
    private fun goOnboarding() {
        startActivity(Intent(this, MainActivity::class.java))
        this.finish()
    }
}