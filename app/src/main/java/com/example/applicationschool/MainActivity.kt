@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.applicationschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.applicationschool.ui.theme.ApplicationSchoolTheme

// Model data classes (simple version për preview)
data class Student(val name: String, val email: String)
data class Course(val name: String, val description: String)
data class Teacher(val firstName: String, val lastName: String, val subject: String)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationSchoolTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Këtu thirr Dashboard me data statike, ose më vonë lidh me ViewModel-et e tu
                    DashboardScreenStatic(
                        students = sampleStudents,
                        courses = sampleCourses,
                        teachers = sampleTeachers
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardScreenStatic(
    students: List<Student>,
    courses: List<Course>,
    teachers: List<Teacher>
) {
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
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            item { SectionHeader("📚 Students") }
            items(students) { student ->
                ItemCard(name = "${student.name} - ${student.email}")
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { SectionHeader("📘 Courses") }
            items(courses) { course ->
                ItemCard(name = "${course.name} - ${course.description}")
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { SectionHeader("👩‍🏫 Teachers") }
            items(teachers) { teacher ->
                ItemCard(name = "${teacher.firstName} ${teacher.lastName} - ${teacher.subject}")
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

// Sample data për preview dhe testim

val sampleStudents = listOf(
    Student("Sara ALiaj", "SaraAliaj@gmail.com"),
    Student("Orela_Kuci", "Orela_Kuci@example.com")
)

val sampleCourses = listOf(
    Course("Mathematics", "Learn basic and advanced math"),
    Course("Java Programming", "Learn the world of programming")
)

val sampleTeachers = listOf(
    Teacher("Anila", "Blerta", "Mathematics"),
    Teacher("Emanuel", "Anisa", "Programming")
)

@Preview(showBackground = true)
@Composable
fun PreviewDashboard() {
    ApplicationSchoolTheme {
        DashboardScreenStatic(
            students = sampleStudents,
            courses = sampleCourses,
            teachers = sampleTeachers
        )
        // Në MainActivity, funksion për të ndërruar fragment

    }
}



private fun Unit.addToBackStack(nothing: Nothing?) {}

private fun Unit.replace(value: Any, fragment: Fragment) {
    TODO("Not yet implemented")
}

private fun Nothing?.beginTransaction() {
    TODO("Not yet implemented")
}
