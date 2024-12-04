package com.example.blog_splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val FULL_TEXT: String = "This is Animated Splash Screen Using Kotlin"
        const val CHAR_DELAY: Long = 200 // Delay for each character (in milliseconds)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blogToText = findViewById<TextView>(R.id.MainScreen)
        animateText(blogToText)
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
