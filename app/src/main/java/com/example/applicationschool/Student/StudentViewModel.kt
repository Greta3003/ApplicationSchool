package com.example.applicationschool.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class StudentViewModel : ViewModel() {


    private val _studentList = MutableLiveData<List<StudentDto>>()
    val studentList: LiveData<List<StudentDto>> get() = _studentList

    fun loadStudents() {
        viewModelScope.launch {
            // TODO: Replace with actual API call or database query
            _studentList.value = listOf(
                StudentDto(1, "Alice Johnson", "alice@example.com"),
                StudentDto(2, "Bob Smith", "bob@example.com")
            )
        }
    }
}
