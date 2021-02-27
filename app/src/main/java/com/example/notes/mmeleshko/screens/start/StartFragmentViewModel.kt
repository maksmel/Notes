package com.example.notes.mmeleshko.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notes.mmeleshko.database.firebase.AppFirebaseRepository
import com.example.notes.mmeleshko.database.room.AppRoomDatabase
import com.example.notes.mmeleshko.database.room.AppRoomRepository
import com.example.notes.mmeleshko.utilits.*

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess:() -> Unit) {
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()}, { showToast(it)})
            }
        }

    }
}