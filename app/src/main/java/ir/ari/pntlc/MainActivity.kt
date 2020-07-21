package ir.ari.pntlc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ir.ari.nlc.PersianNumbersToLettersConverter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainLayout.setOnClickListener(null)
        numberInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                val nlc = PersianNumbersToLettersConverter()
                val result = nlc.getParsedString(numberInput.text.toString())
                numberOutput.text = result
            }
            override fun afterTextChanged(editable: Editable) {}
        })
    }
}