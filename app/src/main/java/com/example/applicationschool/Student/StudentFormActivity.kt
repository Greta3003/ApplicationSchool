package com.example.applicationschool.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.applicationschool.R
//klasa perdoret përdoret për të shtuar ose regjistruar një student të ri
class StudentFormActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")// Anashkalon paralajmërimin për mungesën e ID-së
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_form)// Vendos layout-in që do të shfaqet për këtë aktivitet
        // Gjen fushën e emrit të studentit në layout (input tekst)
        val nameInput = findViewById<EditText>(R.id.editStudentName)
        val saveButton = findViewById<Button>(R.id.buttonSaveStudent) // Gjen butonin për të ruajtur studentin

        saveButton.setOnClickListener {//ruan klikimin e butonit
            val name = nameInput.text.toString() // Merr tekstin e futur nga përdoruesi në fushën e emrit
            // TODO: Call ViewModel or API to save student
        }
    }
}
