package com.example.applicationschool.Model

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
