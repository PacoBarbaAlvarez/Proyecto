package com.example.proyecto

import android.os.Bundle
import com.example.proyecto.databinding.ActivityRegistrarBinding

class Registrar {
    lateinit var  binding: ActivityRegistrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}