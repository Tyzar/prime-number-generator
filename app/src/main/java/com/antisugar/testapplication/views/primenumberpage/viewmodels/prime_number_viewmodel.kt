package com.antisugar.testapplication.views.primenumberpage.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PrimeNumberViewModel :
    ViewModel() {
    private val formState =
        MutableLiveData(
            PrimeNumberFormState()
        )
    val state: LiveData<PrimeNumberFormState> =
        formState

    fun generatePrimeNumbers(inputval: String) {
        //check if empty
        if (inputval.isEmpty()) {
            formState.value =
                formState.value?.copy(
                    errMsg = "Input number harus diisi",
                    primeNumbers = emptyList()
                )
            return
        }

        val numRange = inputval.toInt()
        val primes =
            mutableListOf<Int>()
        for (nums in 1..numRange) {
            if (nums == 1) {
                primes.add(nums)
                continue
            }

            var modZeroCount = 0
            for (divs in 1..nums) {
                if (nums % divs == 0) {
                    modZeroCount++
                }
            }

            if (modZeroCount == 2) {
                primes.add(nums)
            }
        }

        formState.value =
            formState.value?.copy(
                primeNumbers = primes,
                errMsg = null
            )
    }

}

data class PrimeNumberFormState(
    val primeNumbers: List<Int> = emptyList(),
    val errMsg: String? = null
)