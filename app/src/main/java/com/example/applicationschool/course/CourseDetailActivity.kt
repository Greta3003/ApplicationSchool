package com.example.applicationschool.course

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.applicationschool.R

class CourseDetailActivity : ComponentActivity() {// Aktivitet që shfaq detajet e një kursi të caktuar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {// Shtyp paralajmërimin në rast
        // se ndonjë ID mungon në layout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail) // Vendos layout-in për këtë aktivitet
        // Merr ID-në e kursit nga intent-i që ka nisur këtë aktivitet
        val courseId = intent.getLongExtra("courseId", -1L)
        // Gjej TextView-in ku do të shfaqet ID-ja e kursit
        val textView = findViewById<TextView>(R.id.textCourseDetail)
        textView.text = "Details for Course ID: $courseId"// Vendos përmbajtjen e tekstit në TextView me ID-në e kursit

        // TODO: Fetch course details by ID
    }
}
