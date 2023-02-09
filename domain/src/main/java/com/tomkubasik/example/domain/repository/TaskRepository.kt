package com.tomkubasik.example.domain.repository

import com.tomkubasik.example.domain.datasource.TaskLocalDatasource
import com.tomkubasik.example.domain.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskRepository: TaskLocalDatasource
) {

    fun getAll(): Flow<List<Task>> = taskRepository.getAll()

    suspend fun insert(task: Task): Unit = taskRepository.insert(task)

}