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

// Aktiviteti që shfaq listën e mësuesve
class TeacherListActivity : ComponentActivity() {
    // Merr instancën e ViewModel për mësuesit
    private val viewModel: TeacherViewModel by viewModels()
    // Metoda që ekzekutohet kur aktiviteti krijohet
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vendos skedën për aktivitetin që përmban RecyclerView-in për mësuesit
        setContentView(R.layout.activity_teacher_list)
        // Gjej RecyclerView-in në layout
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTeachers)
        // Vendos LinearLayoutManager për të paraqitur artikujt në mënyrë vertikale
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Vëzhgon (observe) listën e mësuesve në ViewModel
        viewModel.teacherList.observe(this, Observer { teachers ->
            // Vendos adapterin për RecyclerView me listën e mësuesve
            recyclerView.adapter = TeacherAdapter(teachers) { teacher ->
                // Kur një mësues klikohet, hap aktivitetin e detajeve
                val intent = Intent(this, TeacherDetailActivity::class.java)
                // Dërgo ID e mësuesit tek aktiviteti tjetër
                intent.putExtra("teacherId", teacher.id)
                // Nis aktivitetin e detajeve të mësuesit
                startActivity(intent)
            }
        })

        // Ngarko të dhënat e mësuesve nga ViewModel
        viewModel.loadTeachers()
    }
}
