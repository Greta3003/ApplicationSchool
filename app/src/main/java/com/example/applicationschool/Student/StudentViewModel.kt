package com.example.applicationschool.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationschool.Dto.StudentDto
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {

    private val _studentList = MutableLiveData<List<StudentDto>>()
    val studentList: LiveData<List<StudentDto>> get() = _studentList

    fun loadStudents() {
        viewModelScope.launch {
            _studentList.value = listOf(
                StudentDto(
                    1, "Sara Aliaj", "Saraaliaj@gmail.com",
                    description = TODO(),
                    year = TODO(),
                    teacher = TODO(),
                    name = TODO(),
                    email = TODO()
                ),
                StudentDto(
                    2, "Orela Kuci", "Orela_Kuci@gmail.com",
                    description = TODO(),
                    year = TODO(),
                    teacher = TODO(),
                    name = TODO(),
                    email = TODO()
                )
            ) as List<StudentDto>?
        }
    }
}

