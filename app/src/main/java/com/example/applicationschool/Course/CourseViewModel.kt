package com.example.applicationschool.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationschool.Dto.CourseDto
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {

    private val _courseList = MutableLiveData<List<CourseDto>>()
    val courseList: LiveData<List<CourseDto>> get() = _courseList

    fun loadCourses() {
        viewModelScope.launch {
            // TODO: Replace with actual API call
            _courseList.value = listOf(
                CourseDto(
                    1, "Mathematics", "Math basics",
                    description = TODO(),
                    year = TODO(),
                    teacher = TODO(),
                    students = TODO(),
                    title = TODO()
                ),
                CourseDto(
                    2, "Biology", "Intro to Biology",
                    description = TODO(),
                    year = TODO(),
                    teacher = TODO(),
                    students = TODO(),
                    title = TODO()
                )
            )
        }
    }
}
