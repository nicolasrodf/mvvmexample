package com.example.mvvmsimple.viewmodel

import androidx.lifecycle.ViewModel

//El parmánetro initValue lo pasaremos utilizando un Factory
class MainActivityViewModel(initValue: Int) : ViewModel() {

    private var sum = 0

    init {
        sum = initValue
    }

    fun getSum() : Int {
        return sum
    }

    fun updateSum(value:Int) {
        sum += value
    }

}