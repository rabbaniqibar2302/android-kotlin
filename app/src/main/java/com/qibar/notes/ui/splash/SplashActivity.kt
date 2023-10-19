package com.qibar.notes.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.qibar.notes.R
import com.qibar.notes.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val homeIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeIntent) //mulai aktifitas
                finish() // finish selesai delay , dan gabisa balik lagi ke splashscreen
            }, 3_000 //lama delay dari splash ke main
        )
    }
}