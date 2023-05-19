package ir.alirezaivaz.numberstoletters

import android.text.TextUtils
import java.math.BigDecimal
import kotlin.math.min

class PersianNumbersToLettersConverter {
    private var splitter: String
    private var zero: String
    private var words = ArrayList<ArrayList<String>>()

    /**
     * constructor
     * build the needed data
     */
    init {
        var temp = arrayListOf<String>()
        temp.add("")
        temp.add("یک")
        temp.add("دو")
        temp.add("سه")
        temp.add("چهار")
        temp.add("پنج")
        temp.add("شش")
        temp.add("هفت")
        temp.add("هشت")
        temp.add("نه")
        words.add(temp)
        temp = arrayListOf()
        temp.add("ده")
        temp.add("یازده")
        temp.add("دوازده")
        temp.add("سیزده")
        temp.add("چهارده")
        temp.add("پانزده")
        temp.add("شانزده")
        temp.add("هفده")
        temp.add("هجده")
        temp.add("نوزده")
        words.add(temp)
        temp = arrayListOf()
        temp.add("")
        temp.add("")
        temp.add("بیست")
        temp.add("سی")
        temp.add("چهل")
        temp.add("پنجاه")
        temp.add("شصت")
        temp.add("هفتاد")
        temp.add("هشتاد")
        temp.add("نود")
        words.add(temp)
        temp = arrayListOf()
        temp.add("")
        temp.add("یکصد")
        temp.add("دویست")
        temp.add("سیصد")
        temp.add("چهارصد")
        temp.add("پانصد")
        temp.add("ششصد")
        temp.add("هفتصد")
        temp.add("هشتصد")
        temp.add("نهصد")
        words.add(temp)
        temp = arrayListOf()
        temp.add("")
        temp.add(" هزار ")
        temp.add(" میلیون ")
        temp.add(" میلیارد ")
        temp.add(" بیلیون ")
        temp.add(" بیلیارد ")
        temp.add(" تریلیون ")
        temp.add(" تریلیارد ")
        temp.add(" کوآدریلیون ")
        temp.add(" کادریلیارد ")
        temp.add(" کوینتیلیون ")
        temp.add(" کوانتینیارد ")
        temp.add(" سکستیلیون ")
        temp.add(" سکستیلیارد ")
        temp.add(" سپتیلیون ")
        temp.add(" سپتیلیارد ")
        temp.add(" اکتیلیون ")
        temp.add(" اکتیلیارد ")
        temp.add(" نانیلیون ")
        temp.add(" نانیلیارد ")
        temp.add(" دسیلیون ")
        words.add(temp)
        splitter = " و "
        zero = "صفر"
    }

    /**
     * add extra zeros to beginning of number so the remainder of number's length to 3 would be 0
     * e.g : 1213 => 001213
     *
     * @param number
     * @return
     */
    private fun prepareNumber(number: String): ArrayList<String> {
        val resultNumber = when (number.length % 3) {
            1 -> {
                "00$number"
            }

            2 -> {
                "0$number"
            }

            else -> {
                number
            }
        }
        return splitStringBySize(resultNumber)
    }

    private fun splitStringBySize(str: String, size: Int = 3): ArrayList<String> {
        val split = arrayListOf<String>()
        for (i in 0 until str.length / size) {
            split.add(str.substring(i * size, min((i + 1) * size, str.length)))
        }
        return split
    }

    /**
     * example : 111 => صد و یازده
     *
     * @param num
     * @return
     */
    private fun threeNumbersToLetter(num: String): String {
        if ("" == num) {
            return ""
        }
        val parsedInt = num.toInt()
        if (parsedInt < 10) {
            return words[0][parsedInt]
        }
        if (parsedInt < 20) {
            return words[1][parsedInt - 10]
        }
        if (parsedInt < 100) {
            val one = parsedInt % 10
            val ten = (parsedInt - one) / 10
            if (one > 0) {
                return words[2][ten] + splitter + words[0][one]
            }
            return words[2][ten]
        }
        val one = parsedInt % 10
        val hundreds = (parsedInt - (parsedInt % 100)) / 100
        val ten = (parsedInt - ((hundreds * 100) + one)) / 10
        val out = arrayListOf<String>()
        out.add(words[3][hundreds])
        val secondPart = ((ten * 10) + one)
        if (secondPart > 0) {
            when {
                secondPart < 10 -> {
                    out.add(words[0][secondPart])
                }

                secondPart < 20 -> {
                    out.add(words[1][secondPart - 10])
                }

                else -> {
                    out.add(words[2][ten])
                    if (one > 0) {
                        out.add(words[0][one])
                    }
                }
            }
        }
        return TextUtils.join(splitter, out)
    }

    /**
     * e.g: 1424124 : یک میلیون و چهارصد و بیست و چهار هزار و یکصد و بیست و چهار
     *
     * @param input
     * @return
     */
    fun getParsedString(input: String): String {
        try {
            if (input.all { it == '0' }) {
                return zero
            }
            if (input.length > 63) {
                return "عدد بزرگ‌تر از مقدار پشتیبانی‌شده است!"
            }
            //using big decimal in order to convert persian numbers .
            //replace all part is used to remove all the non numeric characters
            val processedInput = BigDecimal(input.replace("[^\\d.]".toRegex(), "")).toString()

            val splitNumber = prepareNumber(processedInput)
            val result = arrayListOf<String>()
            val splitLength = splitNumber.size
            for (i in 0 until splitLength) {
                val sectionTitle = words[4][splitLength - (i + 1)]
                val converted: String = threeNumbersToLetter(splitNumber[i])
                if ("" != converted) {
                    result.add(converted + sectionTitle)
                }
            }
            return TextUtils.join(splitter, result)
        } catch (e: Exception) {
            throw e
        }
    }
}