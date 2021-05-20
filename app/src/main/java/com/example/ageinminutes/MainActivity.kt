package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnDatePicker) as Button

        btn.setOnClickListener { view ->
            clickDataPicker(view) }
    }

    val tv11 = findViewById<TextView>(R.id.tv1) as TextView
    val tv22 = findViewById<TextView>(R.id.tv2) as TextView

        fun clickDataPicker(view: View){
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

           val  dpd = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener {
                        view, selectedYear, selectedMonth, selectedDayOfMonth ->
//                    Toast.makeText(
//                        this@MainActivity,
//                        "The chosen year is $selectedYear , the month is $selectedMonth ,and the day of month is $selectedDayOfMonth "
//                        ,Toast.LENGTH_LONG).show()

                        val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                        tv11.setText(selectedDate)

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    val theDate = sdf.parse(selectedDate)

                    val selectedDateInMinutes = theDate!!.time /60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    val currentDateInMinutes = currentDate!!.time / 60000

                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                    tv22.setText(differenceInMinutes.toString())
                }
                ,year
                ,month
                ,day)


            dpd.datePicker.setMaxDate(Date().time - 86400000)
            dpd.show()

        }

    }
