package com.example.conversor_medidas

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor_medidas.databinding.ActivityResultadoConversaoBinding

class Resultado_Conversao : AppCompatActivity() {

    private lateinit var binding : ActivityResultadoConversaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoConversaoBinding.inflate(layoutInflater)

        setContentView(binding.root)

       val adapter =  ArrayAdapter.createFromResource(
            this,
            R.array.num_massa,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinMassaEntrada.adapter = adapter
        binding.spinMassaSaida.adapter = adapter

    }
}