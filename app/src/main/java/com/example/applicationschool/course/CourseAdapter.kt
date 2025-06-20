package com.example.applicationschool.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.Dto.CourseDto
import com.example.applicationschool.R
// Adapter për të shfaqur listën e kurseve në një RecyclerView
class CourseAdapter(
    private val courses: List<CourseDto>,
    private val onItemClick: (CourseDto) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    // ViewHolder për çdo element në listë
    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.courseTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.courseDescription)
        // Lidh të dhënat e kursit me pamjen (UI)
        fun bind(course: CourseDto) {
            titleTextView.text = course.title
            descriptionTextView.text = course.description
            itemView.setOnClickListener {// Kur klikohet një element i listës, thirret funksioni që kemi kaluar si parametër
                onItemClick(course)
            }
        }
    }
    // Krijon pamjen për një element të ri në listë
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }
    // Lidh të dhënat e kursit me ViewHolder-in përkatës
    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }
    // Kthen numrin total të elementeve në listë
    override fun getItemCount(): Int = courses.size
}
