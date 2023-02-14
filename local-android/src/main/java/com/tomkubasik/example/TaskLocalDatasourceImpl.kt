package com.tomkubasik.example

import com.tomkubasik.example.domain.datasource.TaskLocalDatasource
import com.tomkubasik.example.domain.model.Task
import com.tomkubasik.example.model.RoomTask
import com.tomkubasik.example.model.toRoomTask
import com.tomkubasik.example.model.toTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class TaskLocalDatasourceImpl @Inject constructor(
    val appDatabase: AppDatabase,
) : TaskLocalDatasource {

    override fun getAll(): Flow<List<Task>> {
        return appDatabase.taskDao().getAll().map { it.map(RoomTask::toTask) }
    }

    override suspend fun insert(task: Task) {
        appDatabase.taskDao().insertAll(task.toRoomTask())
    }
}
