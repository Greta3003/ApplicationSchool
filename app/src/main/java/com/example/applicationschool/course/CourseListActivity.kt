package com.example.applicationschool.course

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.R

class CourseListActivity : ComponentActivity() {

    private val viewModel: CourseViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCourses)
        recyclerView.layoutManager = LinearLayoutManager(this)

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