package com.noaduron.todo

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Acceptance tests for [TodoService.upcomingTodos].
 * These are the tests the implementation must pass.
 */
class TodoServiceTest {

    private val service = TodoService()
    private val now: LocalDate = LocalDate.of(2026, 1, 15)

    private fun todo(
        id: String,
        dueDate: LocalDate?,
        status: Status = Status.CREATED,
    ) = Todo(id = id, title = "todo-$id", dueDate = dueDate, status = status)

    @Test
    fun emptyListReturnsEmpty() {
        assertEquals(emptyList(), service.upcomingTodos(emptyList(), now))
    }

    @Test
    fun includesTodoDueExactlyToday() {
        val t = todo("a", now)
        assertEquals(listOf(t), service.upcomingTodos(listOf(t), now))
    }

    @Test
    fun includesFutureTodos() {
        val t = todo("a", now.plusDays(3))
        assertEquals(listOf(t), service.upcomingTodos(listOf(t), now))
    }

    @Test
    fun excludesPastDueTodos() {
        val t = todo("a", now.minusDays(1))
        assertEquals(emptyList(), service.upcomingTodos(listOf(t), now))
    }

    @Test
    fun excludesArchivedTodos() {
        val t = todo("a", now.plusDays(2), status = Status.ARCHIVED)
        assertEquals(emptyList(), service.upcomingTodos(listOf(t), now))
    }

    @Test
    fun excludesTodosWithoutDueDate() {
        val t = todo("a", dueDate = null)
        assertEquals(emptyList(), service.upcomingTodos(listOf(t), now))
    }

    @Test
    fun sortsByDueDateAscending() {
        val late = todo("late", now.plusDays(10))
        val soon = todo("soon", now.plusDays(1))
        val today = todo("today", now)
        val result = service.upcomingTodos(listOf(late, soon, today), now)
        assertEquals(listOf(today, soon, late), result)
    }

    @Test
    fun mixesFiltersAndSorting() {
        val archived = todo("archived", now.plusDays(1), status = Status.ARCHIVED)
        val past = todo("past", now.minusDays(5))
        val noDate = todo("noDate", dueDate = null)
        val future = todo("future", now.plusDays(4))
        val today = todo("today", now)
        val result = service.upcomingTodos(
            listOf(archived, past, noDate, future, today),
            now,
        )
        assertEquals(listOf(today, future), result)
    }
}
