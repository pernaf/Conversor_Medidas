package com.example.conversor_medidas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor_medidas.databinding.ActivityResultadoConversaoBinding

class Resultado_Conversao : AppCompatActivity() {

    private lateinit var binding : ActivityResultadoConversaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoConversaoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.tvTeste.text


    }
}