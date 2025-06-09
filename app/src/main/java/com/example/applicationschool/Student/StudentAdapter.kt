package com.example.applicationschool.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.Dto.StudentDto
import com.example.applicationschool.R
// Adaptuesi për listën e studentëve që përdoret në RecyclerView
class StudentAdapter(
    private val students: List<StudentDto>?,
    private val onItemClick: (StudentDto) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    // ViewHolder për të përfaqësuar secilin element të listës (një student)
    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.studentName)
        private val emailTextView: TextView = itemView.findViewById(R.id.studentEmail)
        // Funksioni që mbush të dhënat e studentit në pamje
        fun bind(student: StudentDto) {
            nameTextView.text = student.name.toString()// Vendos emrin e studentit në TextView
            emailTextView.text = student.email.toString()//vendos emailin e studentit ne textview
            itemView.setOnClickListener { onItemClick(student) }// Kur klikohet një element i listës,
        // thërret funksionin onItemClick me studentin përkatës
        }
    }
    // Krijon një ViewHolder të ri për secilën rresht/pamje të listës
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)//ngarkon layout e studentit
        return StudentViewHolder(view)//kthen nje objekt view holder
    }
    // Lidh të dhënat e studentit me pamjen e tij në pozicionin e dhënë
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        students?.get(position)?.let { holder.bind(it) }
    }
    // Kthen numrin total të elementëve që do të shfaqen në listë
    override fun getItemCount(): Int = students?.size ?: 0//nese eshte null do kthej 0
}
