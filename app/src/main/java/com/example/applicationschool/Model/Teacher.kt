package com.example.applicationschool.Model

data class Teacher(
    val id: Int? = null,
    val name: String,
    val specialization: String,
    val courses: List<Int> = emptyList()
)
