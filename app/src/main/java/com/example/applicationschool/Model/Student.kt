package com.example.applicationschool.Model

data class Student(
    val id: Int? = null,
    val name: String,
    val email: String,
    val enrolledCourses: List<Int> = emptyList()
)
