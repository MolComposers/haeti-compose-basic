package org.haeti.todolist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar

/**
 * A simple data class representing a todo item.
 * @property title the title of the todo
 * @property date the date of the todo, basically the creation date
 * @property isDone whether the todo is done or not, default is false
 */
@Entity
data class Todo(
    val title: String,
    val date: Long = Calendar.getInstance().timeInMillis,
    val isDone: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var uniqueId: Int = -1
}
