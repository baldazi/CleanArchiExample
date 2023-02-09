package com.tomkubasik.example

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tomkubasik.example.dao.TaskDao
import com.tomkubasik.example.model.RoomTask

@Database(
    version = 1,
    entities = [RoomTask::class],
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}