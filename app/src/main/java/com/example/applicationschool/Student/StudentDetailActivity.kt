package com.example.applicationschool.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.applicationschool.R
// klasa qe shfaq detajet për një student të caktuar
class StudentDetailActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")// Anashkalon paralajmërimin për mungesën e ID-së
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vendos layout-in që do të përdorë ky aktivitet
        setContentView(R.layout.activity_student_detail)
        // Merr ID-në e studentit që është dërguar nga aktiviteti tjetër përmes intent
        val studentId = intent.getLongExtra("studentId", -1L)// Gjen TextView-in në layout me ID-në e specifikuar
        val textView = findViewById<TextView>(R.id.textStudentDetail)
        textView.text = "Details for Student ID: $studentId"   // Shfaq ID-në e studentit në TextView

        // TODO: Fetch student details by ID-Në të ardhmen këtu do të implementohet logjika për të marrë të dhënat reale të studentit
    }
}
