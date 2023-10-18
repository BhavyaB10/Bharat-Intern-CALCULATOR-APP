package com.example.calculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.calculator.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var splashBinding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)



        val alphaAnimation = AnimationUtils.loadAnimation(applicationContext,R.anim.splash_anim)
        splashBinding.textViewCalculator.startAnimation(alphaAnimation)

        splashBinding.textViewCalculator.animate().translationY(-1400F).setDuration(2700).startDelay = 0
        splashBinding.lottie.animate().translationX(2000F).setDuration(2000).startDelay = 2900
        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
            val intent = Intent(this@SplashScreen,MainActivity::class.java)
            startActivity(intent)
            finish()
        },5000)
    }

}