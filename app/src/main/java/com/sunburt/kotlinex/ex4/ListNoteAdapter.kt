package com.sunburt.kotlinex.ex4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunburt.kotlinex.R

class ListNoteAdapter(val viewModel: NoteViewModel, private val notes: ArrayList<Note>, val context: Context) : RecyclerView.Adapter<
        ListNoteAdapter.NoteHolder>() {

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(note:Note){
            var txtName = itemView.findViewById<TextView>(R.id.txtName)
            var txtDetail = itemView.findViewById<TextView>(R.id.txtDetail)
            var txtPriority = itemView.findViewById<TextView>(R.id.txtPriority)
            var btnDelete = itemView.findViewById<ImageButton>(R.id.btnRemove)

            txtName.text = "Name: ${note.name}"
            txtDetail.text = "Detail: ${note.detail}"
            txtPriority.text = "Priority: ${note.priority}"

            btnDelete.setOnClickListener {
                viewModel.removeNote(note)
                notifyItemRemoved(notes.indexOf(note))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.list_note_adapter, parent, false
        )
        return NoteHolder(v)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bindItems(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}