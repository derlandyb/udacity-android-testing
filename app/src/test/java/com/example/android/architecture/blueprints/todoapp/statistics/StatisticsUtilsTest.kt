package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {
    //If there's no completed task and one active task,
    //then there are 100% percent active tasks and 0% completed tasks.

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred() {
        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "description", false)
        )

        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    //If there's 2 completed tasks and 3 active tasks,
    //then there are 40% percent completed tasks and 60% active tasks
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        val tasks = listOf<Task>(
                Task("title", "description", true),
                Task("title", "description", true),
                Task("title", "description", false),
                Task("title", "description", false),
                Task("title", "description", false)
        )

        // Call our function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // Create an active tasks (the false makes this active)
        val tasks = emptyList<Task>()

        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // Create an active tasks (the false makes this active)
        val tasks = null

        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertEquals(0f, result.activeTasksPercent)
    }
}