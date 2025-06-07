package com.example.applicationschool.Dto

data class StudentDto(
    val id: Long?,
    val code: String?,
    val title: String?,
    val description: String?,
    val year: Int?,
    val teacher: TeacherDto?,
    val students: List<StudentDto.StudentDto>?,
    val name: Any,
    val email: Any
) {
    class StudentDto {
        class StudentDto {

        }

    }
}


