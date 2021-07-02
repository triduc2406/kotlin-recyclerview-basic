package com.sunburt.kotlinex.ex1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunburt.kotlinex.R
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS
import kotlin.collections.ArrayList

class MainActivity2 : AppCompatActivity() {
    //var books: MutableList<Book> = ArrayList()
    private var books = ArrayList<Book>()
    //var adapter: ListBookAdapter? = null
    private var adapter = ListBookAdapter(books)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        revBook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        revBook.adapter = adapter
        val gen: String = if (radAdult.isChecked)
            "Adult"
        else
            "Kid"

        var publish: String = ""
        spPublish.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                publish = spPublish.selectedItem.toString()
            }
        }

        var date: String = ""
        btnDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(this@MainActivity2,
            DatePickerDialog.OnDateSetListener {
                    _, _, _, _ ->
                txtDate.text = "$day/$month/$year"
            },day, month, year)
            dialog.show()
        }

        var string = " "
        var kinds = ArrayList<String>()
        if (chkBeauti.isChecked)
            kinds.add("Beauti")
        if (chkHealth.isChecked)
            kinds.add("Health")
        if (chkLife.isChecked)
            kinds.add("Life")
        if (chkTech.isChecked)
            kinds.add("Tech")
        val kind = kinds.joinToString(string)

        btnAdd.setOnClickListener {
            books.add(Book(editName.text.toString(),editDetail.text.toString(),
            gen, publish, txtDate.text.toString(), kind))
            adapter!!.notifyDataSetChanged()
        }
    }
}