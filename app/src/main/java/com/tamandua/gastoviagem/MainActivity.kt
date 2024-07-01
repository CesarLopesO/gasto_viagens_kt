package com.tamandua.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tamandua.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    private fun calculate() {
        val distanceStr = binding.editDistance.text.toString()
        val priceStr = binding.editPrice.text.toString()
        val autonomyStr = binding.editAutonomy.text.toString()

        if (distanceStr.isNotEmpty() && priceStr.isNotEmpty() && autonomyStr.isNotEmpty()) {
            val distance = distanceStr.toFloat()
            val price = priceStr.toFloat()
            val autonomy = autonomyStr.toFloat()

            val totalValue = ( distance * price) / autonomy
            val totalValueStr = "R$ ${"%.2f".format(totalValue)}"

            binding.textTotalValue.text = totalValueStr
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(view: View?) {
        if (view != null && view.id == R.id.button_calculate) {
            calculate()
        }
    }
}
