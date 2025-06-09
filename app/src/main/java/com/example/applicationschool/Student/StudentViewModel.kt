package com.example.applicationschool.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationschool.Dto.StudentDto
import kotlinx.coroutines.launch
// ViewModel që menaxhon të dhënat e studentëve për UI-në
class StudentViewModel : ViewModel() {
    // MutableLiveData private për listën e studentëve që mund të ndryshojë brenda ViewModel-it
    private val _studentList = MutableLiveData<List<StudentDto>>()
    val studentList: LiveData<List<StudentDto>> get() = _studentList// // LiveData publike që UI mund ta vëzhgojë
    // për ndryshime në listën e studentëve
    // Funksion për ngarkimin e studentëve (aktualisht me të dhëna fiktive)
    fun loadStudents() {
        viewModelScope.launch {// Vendos një listë dummy studentësh në LiveData
            _studentList.value = listOf(
                StudentDto(
                    1, "Sara Aliaj", "Saraaliaj@gmail.com",
                    description = TODO(),// Këtu duhet të vendosen të dhëna të sakta
                    year = TODO(),
                    teacher = TODO(),
                    name = TODO(),
                    email = TODO()
                ),
                StudentDto(
                    2, "Orela Kuci", "Orela_Kuci@gmail.com",
                    description = TODO(),
                    year = TODO(),//vendosen te dhena te sakta
                    teacher = TODO(),
                    name = TODO(),
                    email = TODO()
                )
            ) as List<StudentDto>?
        }
    }
}

