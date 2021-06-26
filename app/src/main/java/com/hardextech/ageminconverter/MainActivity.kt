package com.hardextech.ageminconverter

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Calling the select Date button to perform an action
        btnSelectDate.setOnClickListener { view ->

            // Calling myDatePicker Method inside the onClickListener
            myDatePicker(view)

        }

    }

    private fun myDatePicker(view: View) {

        // Calling the calendar instances
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        // Calling the calendar
        DatePickerDialog(
            this,
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                val dateAssign = "$selectedDayOfMonth/ ${selectedMonth + 1}/ $selectedYear"
                val dateAssignFormat = SimpleDateFormat("dd/MM/yyyy", Locale.UK)
                val parseTime = dateAssignFormat.parse(dateAssign)
                edtSelectDateResult.setText(dateAssign)
                edtSelectDateResult.isVisible = true


                val currentDate =
                    LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
                edtSelectDateMIn.setText(currentDate)
                edtSelectDateMIn.isVisible = true

                // year, month and day are the variable from the calling the calendar instance above.
            },
            year,
            month,
            day
        ).show()


    }


}
