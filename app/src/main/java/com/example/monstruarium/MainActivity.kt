package com.example.monstruarium

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.monstruarium.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Llama a un proceso en un tiempo determinado de tiempo
        Handler().postDelayed({
            // on below line we are
            // creating a new intent
            val intent = Intent(
                this@MainActivity,
                HomeActivity::class.java
            )

            //Comienza la actividad
            startActivity(intent)

            //finaliza la actividad
            finish()
        }, 4000)
    }
}
