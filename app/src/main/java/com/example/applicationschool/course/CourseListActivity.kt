package com.example.applicationschool.course

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.R
// Aktiviteti që shfaq listën e kurseve
class CourseListActivity : ComponentActivity() {

    private val viewModel: CourseViewModel by viewModels() // ViewModel  menaxhon të dhënat e kursit

    @SuppressLint("MissingInflatedId")// Shtyp paralajmërimin për ID-të që mund të mungojnë gjatë inflatimit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)// Vendosim layout-in për këtë aktivitet
        // Inicializojmë RecyclerView për shfaqjen e listës së kurseve
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCourses)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Vëzhgojmë listën e kurseve nga ViewModel-i
        viewModel.courseList.observe(this) { courses ->
            recyclerView.adapter = CourseAdapter(courses) { course ->
                val intent = Intent(this, CourseDetailActivity::class.java)
                intent.putExtra("courseId", course.id)
                startActivity(intent)
            }
        }

        viewModel.loadCourses()
    }
}