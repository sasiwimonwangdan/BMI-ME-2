package th.ac.su.ict.sasiwimon.bmime2

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.floor
import java.math.BigDecimal
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_cal = findViewById<Button>(R.id.btnCal)
        var tvResult = findViewById<TextView>(R.id.tvResult)
        var tvResult2 = findViewById<TextView>(R.id.tvResult2)
        var edtW = findViewById<EditText>(R.id.edtW)
        var edtH = findViewById<EditText>(R.id.edtH)

        btn_cal.setOnClickListener {


            var w = edtW.text.toString().toDouble()
            var h = edtH.text.toString().toDouble()
            h = h/100

            var bmi:Double = w/(h*h)


            var result = "fat"

            if(bmi>30)
                result = "Obese"
            else if (bmi> 25)
                result = "Overweight"
            else if (bmi> 18)
                result = "Healthy"
            else
                result = "Underweight"




            tvResult.setText("Your bmi is "+bmi.round(2).toString())
            tvResult2.setText("("+result+")")

            hideKeyboard()


        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}