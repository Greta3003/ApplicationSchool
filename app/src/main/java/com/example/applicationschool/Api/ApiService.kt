package com.example.applicationschool.Api

import com.example.applicationschool.Dto.CourseDto
import com.example.applicationschool.Dto.CourseStudentAssocDto
import com.example.applicationschool.Dto.CourseTeacherAssocDto
import com.example.applicationschool.Dto.SimpleStringFilterDto
import com.example.applicationschool.Dto.StudentDto
import com.example.applicationschool.Dto.TeacherDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {//nderfaqe qe komunikon me serverin  per ta bere funksionale

    // Course endpoints qe shton  ose perditeson nje kurs
    @POST("upsertCourse")
    suspend fun upsertCourse(@Body courseDto: CourseDto): Response<RespSingleDto<CourseDto>>
    // Filtron kurset në bazë të një stringu kërkimi
    @POST("filterCourses")
    suspend fun filterCourses(@Body filterDto: SimpleStringFilterDto): Response<RespSliceDto<CourseDto>>
    // Fshin një kurs sipas ID-së
    @POST("deleteCourse")
    suspend fun deleteCourse(@Body longIdDto: LongIdDto): Response<RespSingleDto<Void>>
    // Merr të dhënat e një kursi sipas ID-së
    @POST("getCourse")
    suspend fun getCourse(@Body longIdDto: LongIdDto): Response<RespSingleDto<CourseDto>>
    // Lidh një mësues me një kurs
    @POST("associateTeacherToCourse")
    suspend fun associateTeacherToCourse(@Body assocDto: CourseTeacherAssocDto): Response<RespSingleDto<Void>>
    // Heq një mësues nga një kurs
    @POST("removeTeacherFromCourse")
    suspend fun removeTeacherFromCourse(@Body assocDto: CourseTeacherAssocDto): Response<RespSingleDto<Void>>

    // Student endpoints  ku perditeson nje student
    @POST("upsertStudent")
    suspend fun upsertStudent(@Body studentDto: StudentDto): Response<RespSingleDto<StudentDto>>
    // Filtron studentët në bazë të një stringu kërkimi
    @POST("filterStudents")
    suspend fun filterStudents(@Body filterDto: SimpleStringFilterDto): Response<RespSliceDto<StudentDto>>
     //fshin studentit sipas id
    @POST("deleteStudent")
    suspend fun deleteStudent(@Body longIdDto: LongIdDto): Response<RespSingleDto<Void>>

    @POST("associateStudentToCourse")
    suspend fun associateStudentToCourse(@Body assocDto: CourseStudentAssocDto): Response<RespSingleDto<Void>>

    @POST("removeStudentFromCourse")
    suspend fun removeStudentFromCourse(@Body assocDto: CourseStudentAssocDto): Response<RespSingleDto<Void>>

    @POST("getStudent")
    suspend fun getStudent(@Body longIdDto: LongIdDto): Response<RespSingleDto<StudentDto>>

    // Teacher endpoints
    @POST("upsertTeacher")
    suspend fun upsertTeacher(@Body teacherDto: TeacherDto): Response<RespSingleDto<TeacherDto>>

    @POST("filterTeachers")
    suspend fun filterTeachers(@Body filterDto: SimpleStringFilterDto): Response<RespSliceDto<TeacherDto>>

    @POST("deleteTeacher")
    suspend fun deleteTeacher(@Body longIdDto: LongIdDto): Response<RespSingleDto<Void>>

    @POST("getTeacher")
    suspend fun getTeacher(@Body longIdDto: LongIdDto): Response<RespSingleDto<TeacherDto>>
}

// Klasa për dërgimin e id-ve tek backend-i
data class LongIdDto(
    val id: Long
)

// Wrapper për përgjigjet e një objekti
data class RespSingleDto<T>(
    val data: T?,
    val success: Boolean,
    val message: String?
)

// Wrapper për përgjigjet që kthejnë lista të paginuara
data class RespSliceDto<T>(
    val content: List<T>,
    val totalElements: Int,// numri total i elementeve ne backend
    val totalPages: Int,
    val pageNumber: Int
)
