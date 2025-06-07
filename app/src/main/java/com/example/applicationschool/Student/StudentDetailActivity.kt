package com.example.applicationschool.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.applicationschool.R

class StudentDetailActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        val studentId = intent.getLongExtra("studentId", -1L)
        val textView = findViewById<TextView>(R.id.textStudentDetail)
        textView.text = "Details for Student ID: $studentId"

        // TODO: Fetch student details by ID
    }
}
