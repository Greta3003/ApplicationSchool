package com.example.applicationschool.Model
// Kjo është një klasë model që përfaqëson një kurs në sistemin e shkollës
data class Course(
    val id: Long? = null,
    val code: String,
    val title: String,
    val description: String,
    val year: Int,
    val teacherId: Long,
    val students: List<Student>? = null
) {
    val name: CharSequence? = null
}
