package com.example.conversor_medidas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor_medidas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            val intentPrimeira = Intent(this,Resultado_Conversao::class.java)
            startActivity(intentPrimeira)
        }

        }
    }