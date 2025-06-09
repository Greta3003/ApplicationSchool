package com.example.applicationschool.teacher

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.applicationschool.R
// Aktivitet që shfaq detajet e një mësuesi të caktuar
class TeacherDetailActivity : ComponentActivity() {
    // Metoda që ekzekutohet kur aktiviteti krijohet për herë të parë
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vendos layout-in për këtë aktivitet
        setContentView(R.layout.activity_teacher_detail)
// Merr ID-në e mësuesit që është dërguar përmes intent-it
        val teacherId = intent.getLongExtra("teacherId", -1L)// Gjen komponentin TextView në layout ku
        // do të shfaqet ID-ja e mësuesit
        val textView = findViewById<TextView>(R.id.textTeacherDetail)
        textView.text = "Details for Teacher ID: $teacherId"

        // TODO: Fetch and display teacher details by ID
    }
}
