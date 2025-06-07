package com.example.applicationschool.Dto

data class TeacherDto(
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val title: String?,
    val courses: List<StudentDto>?,
    val subject: CharSequence
)
