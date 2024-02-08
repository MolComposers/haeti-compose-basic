package org.haeti.todolist.data.repository

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import org.haeti.todolist.data.data_source.TodoDatabase
import org.haeti.todolist.domain.model.Todo
import org.haeti.todolist.domain.repository.TodoRepository

class TodoRepositoryImpl(application: Application) : TodoRepository {

    private val db = Room.databaseBuilder(
        application,
        TodoDatabase::class.java, "todo-db"
    ).build()

    override fun collectTodos(): Flow<List<Todo>> = db.getTodoDao().getTodos()

    override suspend fun addTodo(todo: Todo) = db.getTodoDao().insert(todo)

    override suspend fun updateTodo(todo: Todo) = db.getTodoDao().update(todo)
    override suspend fun deleteTodo(todo: Todo) = db.getTodoDao().delete(todo)
}