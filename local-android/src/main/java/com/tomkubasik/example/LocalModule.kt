package com.tomkubasik.example

import android.content.Context
import androidx.room.Room
import com.tomkubasik.example.domain.datasource.TaskLocalDatasource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalModule {
    @Provides
    @Singleton
    fun provideMainDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "bc9fe798-a4f0-402e-9f5b-80339d87a041",
        ).build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    internal abstract fun bindTaskLocalDatasource(datasourceImpl: TaskLocalDatasourceImpl): TaskLocalDatasource
}
