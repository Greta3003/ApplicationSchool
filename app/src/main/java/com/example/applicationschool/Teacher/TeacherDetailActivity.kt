package com.example.applicationschool.teacher

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.applicationschool.R

class TeacherDetailActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_detail)

        val teacherId = intent.getLongExtra("teacherId", -1L)
        val textView = findViewById<TextView>(R.id.textTeacherDetail)
        textView.text = "Details for Teacher ID: $teacherId"

        // TODO: Fetch and display teacher details by ID
    }
}
