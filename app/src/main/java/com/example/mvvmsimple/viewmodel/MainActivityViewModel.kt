package com.example.mvvmsimple.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//El parmánetro initValue lo pasaremos utilizando un Factory
class MainActivityViewModel(initValue: Int) : ViewModel() {

    private var total = MutableLiveData<Int>() //Ahora total es un Objeto mutable de tipo Int
    //Como total lo hemos puesto privado, necesitamos crear un acceso de tipo LiveData (totalData) a la variable para observarla desde fuera sin modificarla.
    val totalData : LiveData<Int>
    get() = total

    init {
        total.value = initValue
    }

    fun updateTotal(value:Int) {
        total.value = total.value?.plus(value)
    }

}
