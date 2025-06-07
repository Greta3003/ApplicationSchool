package com.example.applicationschool.Api
import androidx.tracing.perfetto.handshake.protocol.Response
import com.example.applicationschool.Dto.CourseDto
import com.example.applicationschool.Dto.CourseStudentAssocDto
import com.example.applicationschool.Dto.CourseTeacherAssocDto
import com.example.applicationschool.Dto.SimpleStringFilterDto
import com.example.applicationschool.Dto.TeacherDto

interface ApiService {
    // Course endpoints
    @POST("upsertCourse")
    suspend fun upsertCourse(@Body courseDto: CourseDto): Response<RespSingleDto<CourseDto>>

    @POST("filterCourses")
    suspend fun filterCourses(@Body filterDto: SimpleStringFilterDto): Response<RespSliceDto<CourseDto>>

    @POST("deleteCourse")
    suspend fun deleteCourse(@Body longIdDto: LongIdDto): Response<RespSingleDto<Void>>

    @POST("getCourse")
    suspend fun getCourse(@Body longIdDto: LongIdDto): Response<RespSingleDto<CourseDto>>

    @POST("associateTeacherToCourse")
    suspend fun <CourseTeacherAssocDto> associateTeacherToCourse(@Body assocDto: CourseTeacherAssocDto): Response<RespSingleDto<Void>>

    @POST("removeTeacherFromCourse")
    suspend fun removeTeacherFromCourse(@Body assocDto: CourseTeacherAssocDto): Response<RespSingleDto<Void>>

    // Student endpoints
    @POST("upsertStudent")
    suspend fun upsertStudent(@Body studentDto: CourseDto.StudentDto): Response<RespSingleDto<CourseDto.StudentDto>>

    @POST("filterStudents")
    suspend fun filterStudents(@Body filterDto: SimpleStringFilterDto): Response<RespSliceDto<CourseDto.StudentDto>>

    @POST("deleteStudent")
    suspend fun deleteStudent(@Body longIdDto: LongIdDto): Response<RespSingleDto<Void>>

    @POST("associateStudentToCourse")
    suspend fun associateStudentToCourse(@Body assocDto: CourseStudentAssocDto): Response<RespSingleDto<Void>>

    @POST("removeStudentFromCourse")
    suspend fun removeStudentFromCourse(@Body assocDto: CourseStudentAssocDto): Response<RespSingleDto<Void>>

    @POST("getStudent")
    suspend fun getStudent(@Body longIdDto: LongIdDto): Response<RespSingleDto<CourseDto.StudentDto>>

    // Teacher endpoints
    @POST("upsertTeacher")
    suspend fun upsertTeacher(@Body teacherDto: TeacherDto): Response<RespSingleDto<TeacherDto>>

    @POST("filterTeachers")
    suspend fun filterTeachers(@Body filterDto: SimpleStringFilterDto): Response<RespSliceDto<TeacherDto>>

    class RespSliceDto<T> {

    }

    @POST("deleteTeacher")
    suspend fun deleteTeacher(@Body longIdDto: LongIdDto): Response<RespSingleDto<Void>>

    class RespSingleDto<T> {

    }

    @POST("getTeacher")
    suspend fun getTeacher(@Body longIdDto: LongIdDto): Response<RespSingleDto<TeacherDto>>

    interface Response<T> {

        abstract val isSuccessful: Boolean
    }
}

annotation class Body

class LongIdDto {

}

annotation class POST(val value: String)
