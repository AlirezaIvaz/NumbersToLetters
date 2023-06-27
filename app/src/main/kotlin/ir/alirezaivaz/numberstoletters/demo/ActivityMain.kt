package ir.alirezaivaz.numberstoletters.demo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.os.LocaleListCompat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import ir.alirezaivaz.numberstoletters.PersianNumbersToLettersConverter
import ir.alirezaivaz.numberstoletters.demo.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity() {
    private val activityMain = this@ActivityMain
    private lateinit var binding: ActivityMainBinding
    private val githubUrl = "https://github.com/AlirezaIvaz/NumbersToLetters"
    private val githubIssuesUrl = "https://github.com/AlirezaIvaz/NumbersToLetters/issues"
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("fa-IR"))
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.fab.initGitHubFab()
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_issues -> {
                launchUrl(githubIssuesUrl)
            }
        }
        return false
    }

    private fun ExtendedFloatingActionButton.initGitHubFab() {
        smoothShrink()
        this.setOnClickListener {
            extend()
            smoothShrink()
            launchUrl(githubUrl)
        }
        setOnLongClickListener {
            extend()
            smoothShrink()
            true
        }
    }

    private fun ExtendedFloatingActionButton.smoothShrink() {
        Handler(Looper.getMainLooper()).postDelayed({
            this.shrink()
        }, 2000)
    }

    private fun Context.launchUrl(url: String) {
        val params = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(ContextCompat.getColor(this, R.color.github))
            .build()
        CustomTabsIntent.Builder()
            .setDefaultColorSchemeParams(params)
            .setShowTitle(true)
            .build()
            .launchUrl(
                this,
                Uri.parse(url)
            )
    }

}