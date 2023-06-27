package ir.alirezaivaz.numberstoletters.demo

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.os.LocaleListCompat
import ir.alirezaivaz.numberstoletters.PersianNumbersToLettersConverter
import ir.alirezaivaz.numberstoletters.demo.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity() {
    private val activityMain = this@ActivityMain
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("fa-IR"))
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val numbersToLettersConverter = PersianNumbersToLettersConverter()
        binding.numberInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                val number = binding.numberInput.text.toString()
                if (number.isNotEmpty()) {
                    val result =
                        numbersToLettersConverter.getParsedString(binding.numberInput.text.toString())
                    binding.numberOutput.text = result
                } else {
                    binding.numberOutput.text = ""
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        Handler(Looper.getMainLooper()).postDelayed({
            binding.fab.shrink()
        }, 2000)
        binding.fab.setOnClickListener {
            val params = CustomTabColorSchemeParams.Builder()
                .setToolbarColor(ContextCompat.getColor(activityMain, R.color.github))
                .build()
            CustomTabsIntent.Builder()
                .setDefaultColorSchemeParams(params)
                .setShowTitle(true)
                .build()
                .launchUrl(
                    activityMain,
                    Uri.parse("https://github.com/AlirezaIvaz/NumbersToLetters")
                )
        }
    }
}