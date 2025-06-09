package com.example.applicationschool.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationschool.Dto.TeacherDto
import com.example.applicationschool.R
// Adapter për RecyclerView që përdoret për të shfaqur një listë të mësuesve
class TeacherAdapter(
    private val teachers: List<TeacherDto>,// Lista e mësuesve për t’u shfaqur
    private val onItemClick: (TeacherDto) -> Unit
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {
    // Kjo klasë mban referencat e komponenteve të një itemi të listës (ViewHolder)
    inner class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.teacherName)
        private val subjectTextView: TextView = itemView.findViewById(R.id.teacherSubject)
        // Funksion që lidh të dhënat e një mësuesi me pamjen përkatëse në listë
        fun bind(teacher: TeacherDto) {
            nameTextView.text = teacher.firstName
            subjectTextView.text = teacher.subject
            itemView.setOnClickListener { // Vendos një klikues për të trajtuar klikimet në një rresht të listës
                onItemClick(teacher)
            }
        }
    }
    // Krijon një pamje të re për një rresht të listës kur është e nevojshme
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(view)
    }

    // Lidh të dhënat e një mësuesi të caktuar me pamjen përkatëse në pozicionin përkatës
    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.bind(teachers[position])
    }
    // Kthen numrin total të elementeve që duhen shfaqur
    override fun getItemCount(): Int = teachers.size
}
