package com.example.applicationschool.Model
// Kjo klasë përfaqëson një mësues në sistemin e shkollës
data class Teacher(
    val id: Int? = null,
    val name: String,
    val specialization: String,
    val courses: List<Int> = emptyList()
)
