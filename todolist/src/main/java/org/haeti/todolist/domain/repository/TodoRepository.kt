package org.haeti.todolist.domain.repository

import kotlinx.coroutines.flow.Flow
import org.haeti.todolist.domain.model.Todo

interface TodoRepository {
    fun collectTodos(): Flow<List<Todo>>
    suspend fun addTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
}