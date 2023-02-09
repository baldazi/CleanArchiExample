package com.tomkubasik.example.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomkubasik.example.domain.model.Task

@Entity
internal data class RoomTask(
    @PrimaryKey val id: String,
    val description: String,
    val isDone: Boolean
)

internal fun RoomTask.toTask() = Task(
    id, description, isDone
)

internal fun Task.toRoomTask() = RoomTask(
    id, description, isDone
)