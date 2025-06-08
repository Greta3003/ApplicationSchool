package com.example.applicationschool.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.Dto.CourseDto
import com.example.applicationschool.R

class CourseAdapter(
    private val courses: List<CourseDto>,
    private val onItemClick: (CourseDto) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.courseTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.courseDescription)

        fun bind(course: CourseDto) {
            titleTextView.text = course.title
            descriptionTextView.text = course.description
            itemView.setOnClickListener {
                onItemClick(course)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount(): Int = courses.size
}
