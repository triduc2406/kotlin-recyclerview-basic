package com.sunburt.kotlinex.ex3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sunburt.kotlinex.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var students = ArrayList<Student>()
        var adapter = activity?.let { ListStudentAdapter(students, it) }
        revStudent.adapter = adapter
        revStudent.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        var revStudent = view.findViewById<RecyclerView>(R.id.revStudent)
        var major:String = ""
        spMajor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                major = spMajor.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        // lay ra true nhung van in ra male
        // chon female nhung lai ra true


        btnAdd.setOnClickListener {
            var gender:Boolean = true
            if (radMale.isChecked)
                gender = false
            students.add(Student(editName.text.toString(), editClass.text.toString(),
                major, gender))
            adapter!!.notifyDataSetChanged()
        }
    }

}