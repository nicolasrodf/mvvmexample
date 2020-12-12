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

    val inputText = MutableLiveData<String>() //Será el nombre de la variable mutable de nuestro editText para obtener su valor en String (two-way-databinding en el xml)

    init {
        total.value = initValue
    }

    fun updateTotal() {
        //Ahora se obtendrá automaticamente el valor de nuestro editText con two-way-databinding (en el xml)
        //convertir nuestra nueva variable mutable del editText a Integer
        val input:Int
        if(inputText.value?.isNotEmpty() == true) {
            input = inputText.value!!.toInt()
        }else{
            input = 0
        }
        //Sumar al total
        total.value = total.value?.plus(input)
    }

}
