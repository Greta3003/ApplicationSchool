package com.example.applicationschool.student

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.R
// klasa shfaq listën e studentëve në një RecyclerView
class StudentListActivity : ComponentActivity() {
    // Merr një instancë të ViewModel-it për këtë aktivitet
    private val viewModel: StudentViewModel by viewModels()
    // Metoda që ekzekutohet kur krijohet aktiviteti
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)// Vendos layout-in e aktivitetit, i cili përmban një RecyclerView për studentët

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerStudents)
        recyclerView.layoutManager = LinearLayoutManager(this) // Vendos layout-in e listës si Linear (me rreshta vertikal)
// Vëzhgon (observon) ndryshimet në listën e studentëve nga ViewModel-i
        viewModel.studentList.observe(this) { students ->
            // Kur lista ndryshon, krijohet një adapter i ri për ta shfaqur
            recyclerView.adapter = StudentAdapter(students) { student ->
                // Kur klikohet një student, hapet aktiviteti për detajet e tij
                val intent = Intent(this, StudentDetailActivity::class.java)
                intent.putExtra("studentId", student.id)//kalohet id e studentit
                startActivity(intent)//nis aktivitetin e detajeve
            }
        }
// Ngarkon të dhënat e studentëve   duke thirrur view model
        viewModel.loadStudents()
    }
}

