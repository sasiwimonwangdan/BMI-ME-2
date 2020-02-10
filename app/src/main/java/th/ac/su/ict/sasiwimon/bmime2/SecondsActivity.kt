package th.ac.su.ict.sasiwimon.bmime2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconds)
        val bmi  = intent.getDoubleExtra("bmi",0.0)
        val result  = intent.getStringExtra("result")
        val height  = intent.getDoubleExtra("height",-1.0)
        val weight  = intent.getDoubleExtra("weight",-1.0)

        var btnExit   = findViewById<Button>(R.id.btnExit)
        var tvrBmi    = findViewById<TextView>(R.id.tvrBmi)
        var tvrResult = findViewById<TextView>(R.id.tvrResult)
        var tvrHw     = findViewById<TextView>(R.id.tvrHw)

        tvrBmi.setText(bmi.round(2).toString())
        tvrResult.setText(result)
        tvrHw.setText("height: "+height+" weight: "+weight)

        var btnShare = findViewById<Button>(R.id.btnShare)
        btnShare.setOnClickListener{

            var value    = "My BMI is "+bmi.round(2)+" ("+result+")"

            var intent     = Intent()
            intent.action  = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,value)
            intent.type    = "text/plan"

            startActivity(Intent.createChooser(intent,"share Info"))
        }

        btnExit.setOnClickListener {
            var Exit = Intent(this@SecondsActivity,MainActivity::class.java)

            startActivity(Exit)
        }
    }

}
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}
