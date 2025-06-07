package com.example.applicationschool.teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.applicationschool.Dto.TeacherDto

class TeacherViewModel : ViewModel() {

    private val _teacherList = MutableLiveData<List<TeacherDto>>()
    val teacherList: LiveData<List<TeacherDto>> = _teacherList

    fun loadTeachers() {
        // Këtu vendos të dhënat statike për testim.
        val dummyTeachers = listOf(
            TeacherDto(
                1, "Ana Krasniqi", "Matematika",
                title = TODO(),
                courses = TODO(),
                subject = TODO(),
            ),
            TeacherDto(
                2, "Blerim Hoxha", "Fizika",
                title = TODO(),
                courses = TODO(),
                subject = TODO(),
            ),
            TeacherDto(
                3, "Elira Berisha", "Kimia",
                title = TODO(),
                courses = TODO(),
                subject = TODO(),
            )
        )
        _teacherList.value = dummyTeachers
    }
}
