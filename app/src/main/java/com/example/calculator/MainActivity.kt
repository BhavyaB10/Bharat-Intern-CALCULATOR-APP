package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.zero.setOnClickListener {
            binding.inoutText.append("0")
        }

        binding.one.setOnClickListener {

            binding.inoutText.append("1")

        }
        binding.two.setOnClickListener {
            binding.inoutText.append("2")

        }
        binding.three.setOnClickListener {
            binding.inoutText.append("3")
        }
        binding.four.setOnClickListener {
            binding.inoutText.append("4")
        }
        binding.five.setOnClickListener {
            binding.inoutText.append("5")
        }
        binding.six.setOnClickListener {
            binding.inoutText.append("6")
        }
        binding.seven.setOnClickListener {
            binding.inoutText.append("7")
        }
        binding.eight.setOnClickListener {
            binding.inoutText.append("8")
        }
        binding.nine.setOnClickListener {
            binding.inoutText.append("9")
        }
        binding.plus.setOnClickListener {
            binding.inoutText.append("+")
        }
        binding.minus.setOnClickListener {
            binding.inoutText.append("-")
        }
        binding.mul.setOnClickListener {
            binding.inoutText.append("*")
        }
        binding.div.setOnClickListener {
            binding.inoutText.append("/")
        }
        binding.clear.setOnClickListener {

        }
        binding.AC.setOnClickListener {
            binding.inoutText.text=""
            binding.outputText.text=""
        }
        binding.dot.setOnClickListener {
            binding.inoutText.append(".")
        }
        binding.mode.setOnClickListener {
            binding.inoutText.append("%")
        }
        binding.clear.setOnClickListener {

           val length=binding.inoutText.length()
            if(length>0){
                binding.inoutText.text=binding.inoutText.text.subSequence(0,length-1)
            }

        }

        binding.equal.setOnClickListener {

            try {
                val expression = ExpressionBuilder(binding.inoutText.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()) {
                    binding.outputText.text = longResult.toString()
                } else {
                    binding.outputText.text = result.toString()
                }
            }catch (e:Exception){

                Toast.makeText(
                    applicationContext,
                    "Please enter digits to calculate",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }

}