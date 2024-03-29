package org.haeti.todolist.ui.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import org.haeti.todolist.R
import org.haeti.todolist.domain.model.Todo
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TodoItem(
    todo: Todo,
    onClick: (todo: Todo) -> Unit = {},
    onDeleteClick: (todo: Todo) -> Unit = {},
) {
    val format = SimpleDateFormat(stringResource(R.string.date_format_std), Locale.getDefault())

    Row(

    ) {
        Icon(
            modifier = Modifier
                .padding(8.dp)
                .clickable { onDeleteClick(todo) },
            painter = painterResource(id = R.drawable.ic_delete_24),
            contentDescription = "Delete Todo",
            tint = Color(0xFFA51212)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = format.format(Date(todo.date)),
                color = if (todo.isDone) Color.Gray else Color.Black,
                style = TextStyle(
                    textDecoration =
                    if (todo.isDone) TextDecoration.LineThrough else TextDecoration.None
                )
            )

            Text(
                text = todo.title,
                color = if (todo.isDone) Color.Gray else Color.Black,
                style = TextStyle(
                    textDecoration =
                    if (todo.isDone) TextDecoration.LineThrough else TextDecoration.None
                )
            )
        }

        if (todo.isDone) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete_24),
                contentDescription = "Done",
                tint = Color(0xFF00BCD4)
            )
        }

    }
}