package com.example.phonecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var arith = false
    var cal: String? = null
    var value1: Any = 0
    var value2: Any = 0
    var result: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn0.setOnClickListener { appendNumber(0, binding) }
        binding.btn1.setOnClickListener { appendNumber(1, binding) }
        binding.btn2.setOnClickListener { appendNumber(2, binding) }
        binding.btn3.setOnClickListener { appendNumber(3, binding) }
        binding.btn4.setOnClickListener { appendNumber(4, binding) }
        binding.btn5.setOnClickListener { appendNumber(5, binding) }
        binding.btn6.setOnClickListener { appendNumber(6, binding) }
        binding.btn7.setOnClickListener { appendNumber(7, binding) }
        binding.btn8.setOnClickListener { appendNumber(8, binding) }
        binding.btn9.setOnClickListener { appendNumber(9, binding) }
        binding.btnDiv.setOnClickListener {
            binding.tvSub.append(binding.tvMain.text)
            value1 = binding.tvMain.text.toString()
            binding.tvSub.append(" ÷ ")
            arith = true
            cal = "÷"
            binding.tvMain.text = ""
        }
        binding.btnMul.setOnClickListener {
            binding.tvSub.append(binding.tvMain.text)
            value1 = binding.tvMain.text.toString()
            binding.tvSub.append(" × ")
            arith = true
            cal = "×"
            binding.tvMain.text = ""
        }
        binding.btnMin.setOnClickListener {
            binding.tvSub.append(binding.tvMain.text)
            value1 = binding.tvMain.text.toString()
            binding.tvSub.append(" - ")
            arith = true
            cal = "-"
            binding.tvMain.text = ""
        }
        binding.btnPlus.setOnClickListener {
            binding.tvSub.append(binding.tvMain.text)
            value1 = binding.tvMain.text.toString()
            binding.tvSub.append(" + ")
            arith = true
            cal = "+"
            binding.tvMain.text = ""
        }
        binding.btnPercent.setOnClickListener{
            binding.tvSub.append(binding.tvMain.text)
            value1 = binding.tvMain.text.toString()
            binding.tvSub.append(" % ")
            arith = true
            cal = "%"
            binding.tvMain.text = ""
        }
        binding.btnEqual.setOnClickListener {
            binding.tvSub.append(binding.tvMain.text)
            value2 = binding.tvMain.text.toString()
            if(value1.toString().contains(".") || value2.toString().contains(".")){
                when(cal){
                    "÷" -> {
                        result = String.format("%.8f", value1.toString().toDouble() / value2.toString().toDouble())
                        binding.tvMain.setText(result)
                    }
                    "×" -> {
                        result = String.format("%.8f", value1.toString().toDouble() * value2.toString().toDouble())
                        binding.tvMain.setText(result)
                    }
                    "-" -> {
                        result = String.format("%.8f", value1.toString().toDouble() - value2.toString().toDouble())
                        binding.tvMain.setText(result)
                    }
                    "+" -> {
                        result = String.format("%.8f", value1.toString().toDouble() + value2.toString().toDouble())
                        binding.tvMain.setText(result)
                    }
                    "%" -> {
                        result = String.format("%.8f", value1.toString().toDouble() * 0.01 * value2.toString().toDouble())
                        binding.tvMain.setText(result)
                    }
                }
            }else{
                when(cal){
                    "÷" -> {
                        result = "${(value1.toString().toInt() / value2.toString().toInt())}"
                        binding.tvMain.setText(result)
                    }
                    "×" -> {
                        result = "${(value1.toString().toInt() * value2.toString().toInt())}"
                        binding.tvMain.setText(result)
                    }
                    "-" -> {
                        result = "${(value1.toString().toInt() - value2.toString().toInt())}"
                        binding.tvMain.setText(result)
                    }
                    "+" -> {
                        result = "${(value1.toString().toInt() + value2.toString().toInt())}"
                        binding.tvMain.setText(result)
                    }
                    "%" -> {
                        result = "${(value1.toString().toInt() * 0.01 * value2.toString().toInt())}"
                        binding.tvMain.setText(result)
                    }
                }
            }

        }
        binding.btnAc.setOnClickListener {
            value1 = 0
            value2 = 0
            arith = false
            cal = ""
            result = ""
            binding.tvMain.text = ""
            binding.tvSub.text = ""
        }
        binding.btnBack.setOnClickListener {
            binding.tvMain.setText(binding.tvMain.text.dropLast(1))
        }
        binding.btnDot.setOnClickListener {
            if (binding.tvMain.text.length == 0){
                binding.tvMain.append("0.")
            } else {
                binding.tvMain.append(".")
            }
        }
    }
    fun appendNumber(num: Int, binding: ActivityMainBinding) {
        if (arith != true) {
            if (binding.tvMain.text.toString() == "0") {
                binding.tvMain.setText("${num}")
            } else {
                binding.tvMain.append("${num}")
            }
        } else {
            if (binding.tvMain.text.toString() == "0") {
                binding.tvMain.setText("${num}")
            } else {
                binding.tvMain.append("${num}")
            }
        }
    }
}
