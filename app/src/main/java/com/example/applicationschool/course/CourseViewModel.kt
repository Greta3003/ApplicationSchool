package com.example.applicationschool.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationschool.Dto.CourseDto
import com.example.applicationschool.Dto.StudentDto
import com.example.applicationschool.Dto.TeacherDto
import kotlinx.coroutines.launch
// ViewModel për menaxhimin e të dhënave të kursit në mënyrë reaktive
class CourseViewModel : ViewModel() {
    // MutableLiveData që ruan listën e kurseve, e cila mund të ndryshojë
    private val _courseList = MutableLiveData<List<CourseDto>>()
    val courseList: LiveData<List<CourseDto>> get() = _courseList
    // LiveData që ekspozohet për tu vëzhguar nga UI, pa mundësi ndryshimi nga jashtë
    fun loadCourses() {
        viewModelScope.launch {
            val dummyTeacher = TeacherDto(    // Krijohet një mësues i improvizuar (dummy) për qëllime testimi
                id = 1,
                firstName = "Ana",
                lastName = "Krasniqi",
                title = "Prof.",
                subject = "Matematika",
                name = "Ana Krasniqi"
            )

            val dummyStudents = listOf( // Krijohet një listë me studentë të improvizuar që i përkasin kursit
                StudentDto(
                    id = 1,
                    code = "ST101",
                    title = "Znj.",
                    description = "Excellent student",
                    year = 2024,
                    teacher = dummyTeacher,
                    name = "Alice Johnson",
                    email = "alice@example.com"
                ),
                StudentDto(
                    id = 2,
                    code = "ST102",
                    title = "Z.",
                    description = "Good performance",
                    year = 2024,
                    teacher = dummyTeacher,
                    name = "Bob Smith",
                    email = "bob@example.com"
                )
            )

            _courseList.value = listOf(
                CourseDto(
                    id = 1,
                    code = "MATH101",
                    name = "Matematika",
                    title = "Bazat e Matematikës",
                    description = "Mësimi i bazave të matematikës",
                    year = 2024,
                    teacher = dummyTeacher,
                    students = dummyStudents
                ),
                CourseDto(
                    id = 2,
                    code = "BIO101",
                    name = "Biologji",
                    title = "Hyrje në Biologji",
                    description = "Studimi i organizmave të gjallë",
                    year = 2024,
                    teacher = dummyTeacher,
                    students = dummyStudents
                )
            )
        }
    }
}
