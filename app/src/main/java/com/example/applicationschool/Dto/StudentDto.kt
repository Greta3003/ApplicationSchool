package com.example.applicationschool.Dto
//data klas qe perfaqeson te dhenat e studentit
data class StudentDto(
    val id: Long?,
    val code: String?,
    val title: String?,
    val description: String?,
    val year: Int?,
    val teacher: TeacherDto?, // mund të jetë null
    val name: String,
    val email: String
)




