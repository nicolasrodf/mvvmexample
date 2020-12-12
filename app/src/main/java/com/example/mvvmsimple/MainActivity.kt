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
        binding.myViewModel = viewModel //asociamos el objeto databinding creado en el xml con nuestro ViewModel
        binding.lifecycleOwner = this //registrar el lifecycleOwner (para el usar LiveData con Databinding)
    }
}