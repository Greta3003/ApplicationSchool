package com.example.applicationschool.Dto

data class TeacherDto(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val title: String,
    val subject: String,
    val name: String, // Kombinimi i first + last në një fushë
    val courses: List<CourseDto>? = null
)
