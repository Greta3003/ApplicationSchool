package com.example.applicationschool.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.Dto.StudentDto
import com.example.applicationschool.R

class StudentAdapter(
    private val students: List<StudentDto>?,
    private val onItemClick: (StudentDto) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.studentName)
        private val emailTextView: TextView = itemView.findViewById(R.id.studentEmail)

        fun bind(student: StudentDto) {
            nameTextView.text = student.name.toString()
            emailTextView.text = student.email.toString()
            itemView.setOnClickListener { onItemClick(student) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        students?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = students?.size ?: 0
}
