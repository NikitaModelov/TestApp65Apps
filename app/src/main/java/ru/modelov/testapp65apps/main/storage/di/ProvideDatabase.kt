package ru.modelov.testapp65apps.main.storage.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

inline fun <reified T : RoomDatabase> provideDatabase(context: Context, databaseName: String) =
    Room.databaseBuilder(context, T::class.java, databaseName)
        .fallbackToDestructiveMigration()
        .build()