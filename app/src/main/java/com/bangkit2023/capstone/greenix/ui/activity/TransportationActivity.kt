package com.bangkit2023.capstone.greenix.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.bangkit2023.capstone.greenix.databinding.ActivityTransportationBinding

class TransportationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransportationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransportationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getTransportationTitle()
        slideCounter()
        onClick()
    }

    private fun onClick() {
        binding.btnCalculateTransportation.setOnClickListener {
            calculate()
        }
    }

    private fun getTransportationTitle() {
        val title = intent.getStringExtra("title")
        binding.tvTitle.text = title
    }

    private fun calculate() {
        val etDistance = binding.etSliderCounter.text.toString().removeSuffix(" Km").toFloatOrNull()
        val carbonValue = intent.getFloatExtra("carbon", 0F)

        if (etDistance != null) {
            val result = etDistance * carbonValue
            val format = String.format("%.2f", result)
            val intent = Intent(this@TransportationActivity, MainActivity::class.java)
            intent.putExtra("result", format)
            startActivity(intent)
        } else {
            Toast.makeText(this@TransportationActivity, "Error calculating", Toast.LENGTH_SHORT).show()
        }
    }

    private fun slideCounter() {
        binding.slider.valueFrom = 0F
        binding.slider.valueTo = 200F
        binding.slider.setLabelFormatter{ value: Float ->
            value.toInt().toString()
        }
        binding.slider.addOnChangeListener { slider, value, fromUser ->
            val counterValue = value.toInt().toString()
            val result = "$counterValue Km"
            binding.etSliderCounter.text = Editable.Factory.getInstance().newEditable(result)
        }

        binding.etSliderCounter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString().removeSuffix(" Km")
                val value = if (text.isNotBlank()) text.toFloatOrNull() else binding.slider.valueFrom
                binding.slider.value = value ?: binding.slider.valueFrom
            }
        })
    }
}