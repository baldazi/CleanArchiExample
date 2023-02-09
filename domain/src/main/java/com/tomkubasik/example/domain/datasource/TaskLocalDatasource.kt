package com.tomkubasik.example.domain.datasource

import com.tomkubasik.example.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskLocalDatasource {
    fun getAll(): Flow<List<Task>>

    suspend fun insert(task: Task)
}