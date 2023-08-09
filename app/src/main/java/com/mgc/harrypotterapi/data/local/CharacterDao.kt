package com.mgc.harrypotterapi.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mgc.harrypotterapi.data.local.model.CharacterLocal

// Create
// Read
// Update
// Delete
//Crea las peticiones para la bbdd local

@Dao
interface CharacterDao {

    @Query("SELECT * FROM CharacterTable")
    suspend fun getAll(): List<CharacterLocal>

    // TODO


    @Query("SELECT * FROM CharacterTable WHERE id=:id")
    suspend fun getCharacterById(id: String) : CharacterLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<CharacterLocal>)

    @Delete
    suspend fun delete(model: CharacterLocal)

}