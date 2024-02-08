package org.haeti.todolist.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.haeti.todolist.domain.model.Todo

@Dao
interface TodoDao {

    /**
     * Get all todos from the database, ordered by date in descending order.
     * @return a flow of list of todos
     */
    @Query("SELECT * FROM todo ORDER BY date DESC")
    fun getTodos(): Flow<List<Todo>>

    /**
     * Insert a todo into the database, if the todo already exists, replace it.
     * @param todo the todo to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}