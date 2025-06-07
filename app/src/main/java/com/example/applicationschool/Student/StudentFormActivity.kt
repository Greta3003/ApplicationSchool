package com.example.applicationschool.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.applicationschool.R

class StudentFormActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_form)

        val nameInput = findViewById<EditText>(R.id.editStudentName)
        val saveButton = findViewById<Button>(R.id.buttonSaveStudent)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            // TODO: Call ViewModel or API to save student
        }
    }
}
