package com.monjur.todoapp.hilt

import android.content.Context
import androidx.room.Room
import com.monjur.todoapp.dao.ToDoDao
import com.monjur.todoapp.room.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideToDoDao(appDatabase: ToDoDatabase): ToDoDao {
        return appDatabase.toDoDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ToDoDatabase {
        return Room.databaseBuilder(
            appContext,
            ToDoDatabase::class.java,
            "ToDoDB"
        ).build()
    }
}