package com.example.applicationschool.Dto

data class CourseDto(
    val id: Long?,
    val code: String,
    val name: String,
    val title: String,
    val description: String,
    val year: Int,
    val teacher: TeacherDto?, // Optional
    val students: List<StudentDto>
)
