package com.sunburt.kotlinex.ex4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sunburt.kotlinex.R
import kotlinx.android.synthetic.main.fragment_note_home.*

class NoteHomeFragment : Fragment() {
    var mNoteViewModel: NoteViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var revNote = view.findViewById<RecyclerView>(R.id.revNote)
        var npPriority = view.findViewById<NumberPicker>(R.id.npPriority)
        npPriority.maxValue = 10
        npPriority.minValue = 1
        val factory = NoteViewModelFactory()
        mNoteViewModel = ViewModelProviders.of(this, factory).get(NoteViewModel::class.java)
        var btnAdd = view.findViewById<Button>(R.id.btnAddNote)
        btnAdd.setOnClickListener {
            addData()
        }
        initialiseAdapter()
    }

    private fun initialiseAdapter() {
        revNote.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        observeData()
    }

    private fun observeData() {
        mNoteViewModel?.getListNoteLiveData()?.observe(viewLifecycleOwner, Observer {
            //Log.i("data", it.toString())
            revNote.adapter = activity?.let { it1 -> ListNoteAdapter(mNoteViewModel!!, it, it1) }
        })
    }

    private fun addData() {
        mNoteViewModel?.addNote(Note(editName.text.toString(), editDetail.text.toString(),
            npPriority.value))
        revNote.adapter?.notifyDataSetChanged()
    }
}