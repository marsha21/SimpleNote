package com.example.simplenote.helper

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplenote.ui.insert.NoteAddUpdateViewModel
import com.example.simplenote.ui.main.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(private val mApplication: Application)
    : ViewModelProvider.NewInstanceFactory(){

        companion object {
            @Volatile
            private var INSTANCE: ViewModelFactory? = null

            @JvmStatic
            fun getInstance(application: Application) : ViewModelFactory {
                if (INSTANCE == null)
                    synchronized(ViewModelFactory::class.java) {
                        INSTANCE = ViewModelFactory(application)
                    }
                return INSTANCE as ViewModelFactory
            }
        }

        @Suppress("UNCHEKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(mApplication) as T
            }else if (modelClass.isAssignableFrom(NoteAddUpdateViewModel::class.java)) {
                return NoteAddUpdateViewModel(mApplication) as T
            }
            throw IllegalArgumentException("Uknonws ViewModel Class : ${modelClass.name}" )
        }
}