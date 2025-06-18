package com.example.conversor_medidas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor_medidas.databinding.ActivityResultadoConversaoBinding

class Resultado_Conversao : AppCompatActivity() {

    private lateinit var binding : ActivityResultadoConversaoBinding
    private fun converterUnidade(
        valor: Double,
        de: Int,
        para: Int,
        unidades: List<Double>
    ): Double {
        val valorEmBase = valor * unidades[de]
        return valorEmBase / unidades[para]
    }


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
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    massaEntradaSelect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        binding.spinMassaSaida.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    massaSaidaSelect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }


        val adapter2 = ArrayAdapter.createFromResource(
            this,
            R.array.num_distancia,
            android.R.layout.simple_spinner_item
        )
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinDistanciaEntrada.adapter = adapter2
        binding.spinDistanciaSaida.adapter = adapter2

        var distanciaEntradaSelect = 0
        var distanciaSaidaSelect = 0
        binding.spinDistanciaEntrada.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    distanciaEntradaSelect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        binding.spinDistanciaSaida.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    distanciaSaidaSelect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }




        val adapter3 = ArrayAdapter.createFromResource(
            this,
            R.array.num_volume,
            android.R.layout.simple_spinner_item
        )
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinVolumeEntrada.adapter = adapter3
        binding.spinVolumeSaida.adapter = adapter3

        var volumeEntradaSelect = 0
        var volumeSaidaSelect = 0
        binding.spinVolumeEntrada.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    volumeEntradaSelect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        binding.spinVolumeSaida.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    volumeSaidaSelect = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }




        binding.btnConverter.setOnClickListener {

            val massaStr = binding.edtPeso.text.toString()
            val distStr = binding.edtDistancia.text.toString()
            val volStr = binding.edtVolume.text.toString()

            val massaPreenchida = massaStr.isNotEmpty()
            val distanciaPreenchida = distStr.isNotEmpty()
            val volumePreenchido = volStr.isNotEmpty()

            val totalPreenchido = listOf(massaPreenchida, distanciaPreenchida, volumePreenchido).count { it }

            if (totalPreenchido == 0) {
                binding.tvResultado.text = "Digite um valor para converter"
                return@setOnClickListener
            }

            if (totalPreenchido > 1) {
                binding.tvResultado.text = "Preencha apenas um campo por vez"
                return@setOnClickListener
            }

            if (massaPreenchida) {
                val massa = massaStr.toDouble()
                val resultado = converterUnidade(
                    massa, massaEntradaSelect, massaSaidaSelect,
                    unidades = listOf(1000.0, 1.0, 0.001) // Kg, g, mg
                )
                binding.tvResultado.text = "%.2f".format(resultado)
                return@setOnClickListener
            }

            if (distanciaPreenchida) {
                val distancia = distStr.toDouble()
                val resultado = converterUnidade(
                    distancia, distanciaEntradaSelect, distanciaSaidaSelect,
                    unidades = listOf(1000.0, 1.0, 0.01) // km, m, cm
                )
                binding.tvResultado.text = "%.2f".format(resultado)
                return@setOnClickListener
            }

            if (volumePreenchido) {
                val volume = volStr.toDouble()
                val resultado = converterUnidade(
                    volume, volumeEntradaSelect, volumeSaidaSelect,
                    unidades = listOf(1.0, 0.001) // litro, ml
                )
                binding.tvResultado.text = "%.2f".format(resultado)
                return@setOnClickListener
            }


        }
    }
}
