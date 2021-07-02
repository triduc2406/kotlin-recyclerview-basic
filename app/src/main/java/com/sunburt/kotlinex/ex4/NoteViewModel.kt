package com.sunburt.kotlinex.ex4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel(){

    var noteListLiveData = MutableLiveData<ArrayList<Note>>()
    var noteList = ArrayList<Note>()

//    constructor()
//    constructor(liveData: MutableLiveData<ArrayList<Note>>){
//        this.noteListLiveData =  liveData
//    }


    fun getListNoteLiveData() : MutableLiveData<ArrayList<Note>>{
        return noteListLiveData
    }

    fun addNote(note: Note) {
        noteList.add(note)
        noteListLiveData.value = noteList
    }

    fun removeNote(note: Note){
        noteList.remove(note)
        noteListLiveData.value = noteList
    }


}