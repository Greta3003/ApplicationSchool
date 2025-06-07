package com.example.applicationschool.teacher

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.applicationschool.R

class TeacherFormActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_form)

        val nameInput = findViewById<EditText>(R.id.editTeacherName)
        val subjectInput = findViewById<EditText>(R.id.editTeacherSubject)
        val saveButton = findViewById<Button>(R.id.buttonSaveTeacher)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val subject = subjectInput.text.toString()
            // TODO: Call ViewModel or API to save teacher
        }
    }
}
