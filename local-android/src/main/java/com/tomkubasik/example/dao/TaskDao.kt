package com.tomkubasik.example.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tomkubasik.example.model.RoomTask
import kotlinx.coroutines.flow.Flow

@Dao
internal interface TaskDao {

    @Query("SELECT * FROM RoomTask")
    fun getAll(): Flow<List<RoomTask>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg task: RoomTask)

    @Delete
    suspend fun deleteAll(vararg task: RoomTask)
}
