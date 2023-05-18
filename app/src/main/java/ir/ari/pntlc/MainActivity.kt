package ir.ari.pntlc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ir.ari.nlc.PersianNumbersToLettersConverter
import ir.ari.pntlc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.root.setOnClickListener(null)
        binding.numberInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                val nlc = PersianNumbersToLettersConverter()
                val result = nlc.getParsedString(binding.numberInput.text.toString())
                binding.numberOutput.text = result
            }
            override fun afterTextChanged(editable: Editable) {}
        })
    }
}