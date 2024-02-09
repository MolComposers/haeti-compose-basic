package org.haeti.todolist.domain.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.haeti.todolist.data.repository.TodoRepositoryImpl
import org.haeti.todolist.domain.repository.TodoRepository
import org.haeti.todolist.ui.main.MainViewModel

class TodoAndroidViewModelFactory(
    private val application: Application,
    private val todoRepository: TodoRepository = TodoRepositoryImpl(application)
) :
    ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application, todoRepository) as T
        }
        return super.create(modelClass)
    }
}