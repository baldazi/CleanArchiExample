package com.tomkubasik.example.domain.repository

import com.tomkubasik.example.domain.datasource.TaskLocalDatasource
import com.tomkubasik.example.domain.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDatasource: TaskLocalDatasource
) {

    fun getAll(): Flow<List<Task>> = taskDatasource.getAll()

    suspend fun insert(task: Task): Unit = taskDatasource.insert(task)

}