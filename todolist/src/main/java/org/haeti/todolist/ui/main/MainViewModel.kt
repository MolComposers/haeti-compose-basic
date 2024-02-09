package org.haeti.todolist.ui.main

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.haeti.todolist.domain.model.Todo
import org.haeti.todolist.domain.repository.TodoRepository

class MainViewModel(
    application: Application,
    private val todoRepository: TodoRepository
) : AndroidViewModel(application) {

    private val _items = mutableStateOf(emptyList<Todo>())
    val items: State<List<Todo>> = _items

    private var recentlyDeletedTodo: Todo? = null

    fun addTodo(text: String) {
        viewModelScope.launch {
            todoRepository.addTodo(Todo(title = text))
        }
    }

    fun toggle(uniqueId: Int) {
        val todo = _items.value.find { todo -> todo.uniqueId == uniqueId }

        todo?.let {
            viewModelScope.launch {
                todoRepository.updateTodo(it.copy(isDone = !todo.isDone).apply {
                    this.uniqueId = it.uniqueId
                })
            }
        }
    }

    fun deleteTodo(uniqueId: Int) {
        val todo = _items.value.find { todo -> todo.uniqueId == uniqueId }

        todo?.let {
            viewModelScope.launch {
                todoRepository.deleteTodo(it)
                recentlyDeletedTodo = it
            }
        }
    }

    fun restoreTodo() {
        viewModelScope.launch {
            recentlyDeletedTodo?.let {
                todoRepository.addTodo(it)
                recentlyDeletedTodo = null
            } ?: return@launch
        }
    }
}