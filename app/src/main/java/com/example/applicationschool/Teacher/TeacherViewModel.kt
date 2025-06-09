package com.example.applicationschool.teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.applicationschool.Dto.TeacherDto

// ViewModel që menaxhon të dhënat për mësuesit
class TeacherViewModel : ViewModel() {
    // MutableLiveData për listën e mësuesve — e përdorur brenda klasës
    private val _teacherList = MutableLiveData<List<TeacherDto>>()
    // LiveData e cila ekspozohet për jashtë për të mos lejuar modifikime direkte
    val teacherList: LiveData<List<TeacherDto>> = _teacherList
    // Funksion që ngarkon listën e mësuesve (të dhëna testuese/hardcoded)
    fun loadTeachers() {
        _teacherList.value = listOf(
            // Shembuj të dhënash të mësuesve
            TeacherDto(1, "Ana", "Krasniqi", "Prof.", "Matematika", name = "Ana"),
            TeacherDto(2, "Blerim", "Hoxha", "Dr.", "Fizika", name = "Ana"),
            TeacherDto(3, "Elira", "Berisha", "Dr.", "Kimia", name = "Ana")
        )
    }
}
