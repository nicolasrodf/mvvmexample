package com.example.mvvmsimple.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//Esta clase sirve para instanciar un ViewModel y pasarle un parámetro
class MainActivityViewModelFactory(private val value : Int) : ViewModelProvider.Factory {

    //Esta método es por defecto en una clase Factory
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(value) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

////**Otro ejemplo: https://developer.android.com/codelabs/kotlin-android-training-view-model#7