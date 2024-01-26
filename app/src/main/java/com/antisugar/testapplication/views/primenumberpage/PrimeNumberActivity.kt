package com.antisugar.testapplication.views.primenumberpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.antisugar.testapplication.R
import com.antisugar.testapplication.views.primenumberpage.viewmodels.PrimeNumberViewModel

class PrimeNumberActivity :
    AppCompatActivity() {
    private lateinit var resultText: TextView
    private lateinit var inputNumEdit: EditText
    private lateinit var generateBtn: Button
    private val primeNumberViewModel =
        PrimeNumberViewModel()

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(
            savedInstanceState
        )
        setContentView(R.layout.activity_prime_number)

        setupViews()

        setupStateHandler()
    }

    private fun setupStateHandler() {
        primeNumberViewModel.state.observe(
            this
        ) { state ->
            run {
                showError(state.errMsg)
                showPrimeNumbers(
                    state.primeNumbers
                )
            }
        }
    }

    private fun showError(message: String?) {
        if (message == null)
            return

        Toast.makeText(
            this@PrimeNumberActivity,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showPrimeNumbers(
        primeNumbers: List<Int>
    ) {
        val strBuffer = StringBuffer()
        for (num in primeNumbers) {
            strBuffer.append("$num, ")
        }

        resultText.text =
            strBuffer.toString()
    }

    private fun setupViews() {
        inputNumEdit =
            findViewById(R.id.inputNumberEdit)
        generateBtn =
            findViewById<Button?>(R.id.generateBtn).apply {
                setOnClickListener {
                    handleGeneratePrimeNumber()
                }
            }
        resultText =
            findViewById(R.id.resultText)
    }

    private fun handleGeneratePrimeNumber() {
        val inputval =
            inputNumEdit.text.toString()
        primeNumberViewModel.generatePrimeNumbers(
            inputval
        )
    }


}