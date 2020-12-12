package com.example.mvvmsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsimple.databinding.ActivityMainBinding
import com.example.mvvmsimple.viewmodel.MainActivityViewModel
import com.example.mvvmsimple.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = MainActivityViewModelFactory(100) //Pasamos el parámetro inicial a la instancia del ViewModel utilizando un Factory!!
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java) //asociamos el Factory al ViewModel
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //Observamos el cambio de valor de total en el ViewModel para hacer una accion auomática (en este caso actualizar la vista)
        viewModel.totalData.observe(this, Observer {
            binding.tvResult.text = it.toString()
        })
        binding.btnCalculate.setOnClickListener {
            sumValue()
        }
    }

    private fun sumValue() {
        binding.apply {
            if(etEnterNumber.text.trim().isNotEmpty()){
                viewModel.updateTotal(etEnterNumber.text.toString().toInt())
               // tvResult.text = viewModel.getSum().toString() // Ya no es necesario ya que estamos observando su valor con LiveData
            }
        }
    }
}