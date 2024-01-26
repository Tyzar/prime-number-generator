package com.antisugar.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.antisugar.testapplication.views.primenumberpage.PrimeNumberActivity

class StarterActivity :
    AppCompatActivity() {

    private lateinit var nextPageBtn: Button

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(
            savedInstanceState
        )
        setContentView(R.layout.activity_starter)

        setupView()
    }

    private fun setupView() {
        nextPageBtn =
            findViewById(R.id.nextPageBtn)
        nextPageBtn.setOnClickListener {
            val primeNumberPageIntent =
                Intent(
                    this,
                    PrimeNumberActivity::class.java
                )
            startActivity(
                primeNumberPageIntent
            )
        }
    }
}