package com.example.conversor_medidas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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

        var massaEntradaSelect = 0
        var massaSaidaSelect = 0
        binding.spinMassaEntrada.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    massaEntradaSelect = position
                    massaSaidaSelect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        val adapter2 = ArrayAdapter.createFromResource(
            this,
            R.array.num_distancia,
            android.R.layout.simple_spinner_item
        )
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinDistanciaEntrada.adapter = adapter2
        binding.spinDistanciaSaida.adapter = adapter2

        val adapter3 = ArrayAdapter.createFromResource(
            this,
            R.array.num_volume,
            android.R.layout.simple_spinner_item
        )
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinVolumeEntrada.adapter = adapter3
        binding.spinVolumeSaida.adapter = adapter3


        binding.btnConverter.setOnClickListener {

        }






    }
}