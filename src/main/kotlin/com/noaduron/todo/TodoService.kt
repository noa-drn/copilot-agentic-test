package com.noaduron.todo

import java.time.LocalDate

/** Business logic over a list of [Todo] items. */
class TodoService {

    /**
     * Returns the "upcoming" todos the user still needs to act on.
     *
     * A todo is upcoming when ALL of the following hold:
     * - its status is NOT [Status.ARCHIVED];
     * - it has a due date (dueDate is not null);
     * - its due date is on or after [now] (a todo due exactly on [now] is included).
     *
     * The returned list is sorted by due date ascending (earliest first).
     * Todos that are not upcoming are excluded.
     *
     * See README.md and docs/ISSUE.md for the full specification.
     *
     * @param todos the todos to filter
     * @param now the reference day ("today")
     * @return the upcoming todos, earliest due date first
     */
    fun upcomingTodos(todos: List<Todo>, now: LocalDate): List<Todo> {
        TODO("Not implemented yet: this is the feature to implement")
    }
}
