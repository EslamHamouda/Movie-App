package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            move()
        }, 3000)
    }
    private fun move() {
        startActivity(Intent(this, AuthActivity::class.java))
        this.finish()
    }



}