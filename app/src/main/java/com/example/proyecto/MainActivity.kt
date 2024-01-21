package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyecto.Registrar
import com.example.proyecto.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.iniciarSesion.setOnClickListener {
            login()
        }

        binding.registrar.setOnClickListener {
            registrar()
        }


    }

    private fun registrar(){
        startActivity(Intent(this, Registrar::class.java))
    }

    private fun login(){
        if(binding.email.text.isNotEmpty() && binding.contraseA.text.isNotEmpty()){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                binding.email.toString(),
                binding.contraseA.toString()
            )

                .addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this,Listado::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Correo o contraseña incorrectos", Toast.LENGTH_LONG).show()
                    }
                }
        }
        else{
            Toast.makeText(this,"Algun campo esta vacio", Toast.LENGTH_LONG).show()
        }
    }



}