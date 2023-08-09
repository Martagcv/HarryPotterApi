package com.mgc.harrypotterapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mgc.harrypotterapi.data.local.model.CharacterLocal


@Database(entities = [CharacterLocal::class], version = 1, exportSchema = false)

abstract class CharacterDatabase : RoomDatabase() {
    // List of Dao
    abstract fun characterDao(): CharacterDao
}