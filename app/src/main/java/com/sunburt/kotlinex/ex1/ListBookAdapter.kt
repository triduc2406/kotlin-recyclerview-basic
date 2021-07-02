package com.sunburt.kotlinex.ex1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunburt.kotlinex.R


class ListBookAdapter(private val books: ArrayList<Book> ) :
    RecyclerView.Adapter<ListBookAdapter.BookHolder>() {

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(book: Book) {
            var txtName: TextView = itemView.findViewById(R.id.txtName)
            val txtDetail: TextView = itemView.findViewById(R.id.txtDetail)
            val txtGen: TextView = itemView.findViewById(R.id.txtGen)
            val txtPublish: TextView = itemView.findViewById(R.id.txtPublish)
            val txtDate: TextView = itemView.findViewById(R.id.txtDate)
            val txtKind: TextView = itemView.findViewById(R.id.txtKind)
            val btnRemove: ImageButton = itemView.findViewById(R.id.btnRemove)
            txtName.text = book.name
            txtDetail.text = book.detail
            txtGen.text = book.gen
            txtPublish.text = book.publish
            txtDate.text = book.date
            txtKind.text = book.kind
            btnRemove.setOnClickListener {
                deleteItem(position)
            }
        }

        private fun deleteItem(position: Int) {

        }
    }

    // return the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.list_book_adapter,
            parent, false
        )
        return BookHolder(v)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    // binding the data on the list
    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bindItems(books[position])
    }

}