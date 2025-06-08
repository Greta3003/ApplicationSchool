package com.example.applicationschool.teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.applicationschool.Dto.TeacherDto

class TeacherViewModel : ViewModel() {

    private val _teacherList = MutableLiveData<List<TeacherDto>>()
    val teacherList: LiveData<List<TeacherDto>> = _teacherList

    fun loadTeachers() {
        _teacherList.value = listOf(
            TeacherDto(1, "Ana", "Krasniqi", "Prof.", "Matematika", name = "Ana"),
            TeacherDto(2, "Blerim", "Hoxha", "Dr.", "Fizika", name = "Ana"),
            TeacherDto(3, "Elira", "Berisha", "Dr.", "Kimia", name = "Ana")
        )
    }
}
