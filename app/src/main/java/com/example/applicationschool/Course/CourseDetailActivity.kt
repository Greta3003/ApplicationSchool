package com.example.applicationschool.course

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.applicationschool.R

class CourseDetailActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val courseId = intent.getLongExtra("courseId", -1L)
        val textView = findViewById<TextView>(R.id.textCourseDetail)
        textView.text = "Details for Course ID: $courseId"

        // TODO: Fetch course details by ID
    }
}
