package com.example.applicationschool.student

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.R

class StudentListActivity : ComponentActivity() {

    private val viewModel: StudentViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.studentList.observe(this) { students ->
            recyclerView.adapter = StudentAdapter(students) { student ->
                val intent = Intent(this, StudentDetailActivity::class.java)
                intent.putExtra("studentId", student.id)
                startActivity(intent)
            }
        }

        viewModel.loadStudents()
    }
}

