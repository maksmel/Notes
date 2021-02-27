package com.example.notes.mmeleshko.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notes.mmeleshko.utilits.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
}