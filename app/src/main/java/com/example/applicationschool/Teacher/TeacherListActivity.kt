package com.example.applicationschool.teacher

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.R

class TeacherListActivity : ComponentActivity() {

    private val viewModel: TeacherViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTeachers)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obserevo ndryshimet te lista e mësuesve
        viewModel.teacherList.observe(this, Observer { teachers ->
            recyclerView.adapter = TeacherAdapter(teachers) { teacher ->
                val intent = Intent(this, TeacherDetailActivity::class.java)
                intent.putExtra("teacherId", teacher.id)
                startActivity(intent)
            }
        })

        viewModel.loadTeachers()
    }
}
