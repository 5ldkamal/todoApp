package com.example.todo.dataLayer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(arrayOf(Task::class), version = 1)
@TypeConverters(value = [Converters::class])
abstract class DataBaseManager : RoomDatabase(){
    abstract fun getTaskDAO(): TaskDAO

    companion object {
        private var instance: DataBaseManager? = null
        fun init(applicationContext: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(applicationContext, DataBaseManager::class.java, "")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }

        fun getInstance(applicationContext: Context): DataBaseManager {
            return instance!!
        }
    }
}