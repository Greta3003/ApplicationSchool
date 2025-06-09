package com.example.applicationschool.course

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.applicationschool.R
// Aktiviteti për plotësimin e formularit të krijimit ose modifikimit të një kursi
class CourseFormActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")// Shtyp paralajmërimin në rast se ndonjë ID nuk është
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_form) // Vendos layout-in për këtë aktivitet
        // Merr referencën e fushës për emrin e kursit
        val nameInput = findViewById<EditText>(R.id.editCourseName)
        // Merr referencën e butonit për ruajtjen e kursit
        val saveButton = findViewById<Button>(R.id.buttonSaveCourse)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()// Merr tekstin e futur nga përdoruesi
            // TODO: Call ViewModel or API to save course
        }
    }
}