package com.example.applicationschool.Model
// Kjo klasë përfaqëson një student në sistemin e shkollës
data class Student(
    val id: Int? = null,
    val name: String,
    val email: String,
    val enrolledCourses: List<Int> = emptyList()
)
