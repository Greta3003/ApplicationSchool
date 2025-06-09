package com.example.applicationschool.teacher

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.applicationschool.R
// Aktivitet që përdoret për të shtuar ose përditësuar të dhënat e një mësuesi
class TeacherFormActivity : ComponentActivity() {
    // Metoda që ekzekutohet kur aktiviteti krijohet
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vendos skedën XML që përmban formën për mësuesin
        setContentView(R.layout.activity_teacher_form)
// Merr komponentin për futjen e emrit të mësuesit
        val nameInput = findViewById<EditText>(R.id.editTeacherName)
        // Merr komponentin për futjen e lëndës që jep mësuesi
        val subjectInput = findViewById<EditText>(R.id.editTeacherSubject)
        // Merr butonin për ruajtjen e mësuesit
        val saveButton = findViewById<Button>(R.id.buttonSaveTeacher)

        saveButton.setOnClickListener {//ruan butonin
            val name = nameInput.text.toString()// Merr tekstin që është futur si emër
            val subject = subjectInput.text.toString()   // Merr tekstin që është futur si lëndë
            // TODO: Call ViewModel or API to save teacher
        }
    }
}
