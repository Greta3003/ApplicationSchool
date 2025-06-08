package com.example.applicationschool.course

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.applicationschool.R

class CourseFormActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_form)

        val nameInput = findViewById<EditText>(R.id.editCourseName)
        val saveButton = findViewById<Button>(R.id.buttonSaveCourse)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            // TODO: Call ViewModel or API to save course
        }
    }
}