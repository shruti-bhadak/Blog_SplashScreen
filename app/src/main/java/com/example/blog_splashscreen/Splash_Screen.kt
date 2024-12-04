package com.example.blog_splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Splash_Screen : AppCompatActivity() {

    companion object {
        const val FULL_TEXT: String = "blog\nTO"
        const val CHAR_DELAY: Long = 300 // Delay for each character (in milliseconds)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val blogToText = findViewById<TextView>(R.id.blogToText)
        animateText(blogToText)

        // Move to MainActivity after animation is complete
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Splash_Screen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, FULL_TEXT.length * CHAR_DELAY + 1000) // Add extra delay after animation
    }

    private fun animateText(textView: TextView) {
        val handler = Handler(Looper.getMainLooper())
        val currentText = StringBuilder()

        for (i in FULL_TEXT.indices) {
            handler.postDelayed({
                currentText.append(FULL_TEXT[i])
                textView.text = currentText.toString()
            }, CHAR_DELAY * i)
        }
    }
}
