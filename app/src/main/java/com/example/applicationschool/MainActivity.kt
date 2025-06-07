@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.applicationschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applicationschool.course.CourseViewModel
import com.example.applicationschool.student.StudentViewModel
import com.example.applicationschool.teacher.TeacherViewModel
import com.example.applicationschool.ui.theme.ApplicationSchoolTheme

class MainActivity : ComponentActivity() {

    private val studentViewModel: StudentViewModel by viewModels()
    private val courseViewModel: CourseViewModel by viewModels()
    private val teacherViewModel: TeacherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        studentViewModel.loadStudents()
        courseViewModel.loadCourses()
        teacherViewModel.loadTeachers()

        setContent {
            ApplicationSchoolTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashboardScreen(
                        studentViewModel,
                        courseViewModel,
                        teacherViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardScreen(
    studentViewModel: StudentViewModel,
    courseViewModel: CourseViewModel,
    teacherViewModel: TeacherViewModel
) {
    val students by studentViewModel.studentList.observeAsState(emptyList())
    val courses by courseViewModel.courseList.observeAsState(emptyList())
    val teachers by teacherViewModel.teacherList.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier
            .padding(padding)
            .padding(16.dp)
        ) {
            item { SectionHeader("📚 Students") }
            items(students) { student ->
                ItemCard(name = student.name)
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { SectionHeader(" Courses") }
            items(courses) { course ->
                ItemCard(name = course.name)
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { SectionHeader(" Teachers") }
            items(teachers) { teacher ->
                ItemCard(name = teacher.firstName.toString())
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun ItemCard(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
