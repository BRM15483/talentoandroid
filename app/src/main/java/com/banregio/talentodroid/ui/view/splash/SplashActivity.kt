package com.banregio.talentodroid.ui.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.banregio.talentodroid.MainActivity
import com.banregio.talentodroid.R
import com.banregio.talentodroid.databinding.ActivitySplashBinding
import com.banregio.talentodroid.utils.Util

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Falta cambiar icono de API Splash
        installSplashScreen()
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary)
        supportActionBar?.hide()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvVersionApp.text = Util.version()
        //Cambiar timer por lógica para verificar si hay una sesión iniciada
        startTimer()
    }

    private fun startTimer() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }

        }.start()
    }
}