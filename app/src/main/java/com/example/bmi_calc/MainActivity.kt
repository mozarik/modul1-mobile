package com.example.bmi_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bodyShaming.visibility = View.INVISIBLE
        hasilText.visibility = View.INVISIBLE

        btn.setOnClickListener {

            //            hasilText.visibility = View.VISIBLE

            var berat: Double = beratEdit.text.toString().toDouble()
            var tinggi: Double = tinggiEdit.text.toString().toDouble()

            var bmi: Double = (berat * 703) / (tinggi*tinggi)


            Log.i("msg", "+++weigh is ${berat}, tinggi is ${tinggi}, bmi is ${bmi}")

            hasilText.visibility = View.VISIBLE
            hasilText.text = "BMI kamu adalah ${String.format("%.2f", bmi)}. Kategori ${bmiKat(bmi)} "
        }
    }

    fun bmiKat(bmi: Double): String {
        var ans = ""

        if (bmi < 18.5) {
            ans = "Kurus"
            bodyShaming.visibility = View.INVISIBLE
        } else if (bmi > 18.5 && bmi < 24.9) {
            ans = "normal"
            bodyShaming.visibility = View.INVISIBLE
        } else if (bmi > 25 && bmi < 29.9) {
            ans = "Berat Berlebih"
            bodyShaming.visibility = View.VISIBLE
        } else {
            ans = "Obesitas"
            bodyShaming.visibility = View.VISIBLE
        }

        return ans
    }
}

/*
BMI = b*703/sqr(t);

Kurus = < 18.5
Normal = 18.5 - 24.9
Berat berlebih = 25-29.9
Obesitas = BMI >= 30
*/