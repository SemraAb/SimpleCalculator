package com.samra.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samra.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var operators = Operators()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener {
            handleOperators(operators::addtion)
        }
        binding.minus.setOnClickListener {
            handleOperators(operators::minus)

        }
        binding.multiply.setOnClickListener {
            handleOperators(operators::multiplication)

        }
        binding.division.setOnClickListener {
            handleOperators(operators::division)

        }
    }

    private fun handleOperators(operations: (Double, Double) -> Double) {
        val num1 = binding.editNum1.text.toString().toDoubleOrNull()
        val num2 = binding.editNum2.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            var result = operations(num1, num2)
            binding.resultView.setText(result.toString())
        } else {
            binding.resultView.setText("Eded daxil ele")
        }
    }
}
