package com.example.applicationschool.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.Dto.TeacherDto
import com.example.applicationschool.R

class TeacherAdapter(
    private val teachers: List<TeacherDto>,
    private val onItemClick: (TeacherDto) -> Unit
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.teacherName)
        private val subjectTextView: TextView = itemView.findViewById(R.id.teacherSubject)

        fun bind(teacher: TeacherDto) {
            nameTextView.text = teacher.firstName
            subjectTextView.text = teacher.subject
            itemView.setOnClickListener {
                onItemClick(teacher)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.bind(teachers[position])
    }

    override fun getItemCount(): Int = teachers.size
}
