package com.sunburt.kotlinex.ex4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Init ViewModel , prevent app from cashing in case activity not found
class NoteViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
            return NoteViewModel() as T
        }
        throw IllegalArgumentException("UnknownViewModel")
    }
}