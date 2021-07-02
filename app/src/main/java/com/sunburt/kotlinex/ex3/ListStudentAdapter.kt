package com.sunburt.kotlinex.ex3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunburt.kotlinex.R
import kotlinx.android.synthetic.main.list_student_adapter.view.*


class ListStudentAdapter(private val students: ArrayList<Student>, private val context: Context) :
    RecyclerView.Adapter<ListStudentAdapter.StudentHolder>() {

    val studentList: ArrayList<Student> = students

    class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(student: Student) {
            var txtName = itemView.findViewById<TextView>(R.id.txtName)
            var txtClass = itemView.findViewById<TextView>(R.id.txtClass)
            var txtMajor = itemView.findViewById<TextView>(R.id.txtMajor)
            var txtGender = itemView.findViewById<TextView>(R.id.txtGender)
            var btnRemove = itemView.findViewById<ImageButton>(R.id.btnRemove)
            txtName.text = "Name: ${student.name}"
            txtClass.text = "Class: ${student.studentClass}"
            txtMajor.text = "Major: ${student.major}"
            if (student.gender)
                txtGender.text = "Gender: Female"
            else
                txtGender.text = "Gender: Male"

        }

    }

    // return the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.list_student_adapter, parent, false
        )
        return StudentHolder(v)
    }

    // binding data on the list
    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.bindItems(students[position])
        holder.itemView.btnRemove.setOnClickListener {
            students.remove(students[position])
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }
}