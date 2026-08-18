package com.noaduron.todo

import java.time.LocalDate

/** The lifecycle status of a todo. */
enum class Status {
    CREATED,
    STARTED,
    ENDED,
    ARCHIVED,
}

/**
 * A single todo item.
 *
 * @property id unique identifier
 * @property title short human-readable title
 * @property dueDate the day the todo is due, or null if it has no due date
 * @property status the current lifecycle status
 */
data class Todo(
    val id: String,
    val title: String,
    val dueDate: LocalDate?,
    val status: Status,
)
