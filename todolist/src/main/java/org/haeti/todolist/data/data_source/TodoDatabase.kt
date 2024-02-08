package org.haeti.todolist.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import org.haeti.todolist.domain.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao
}