package com.muhammadfarhaan.apps.dbroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    abstract fun tambahAktivis(aktivisEntity: Entity)

    @Delete
    abstract fun hapusAktivis(aktivisEntity: Entity)

    @Query("SELECT * FROM Entity")
    abstract fun tampilSeluruhAktivis(): kotlin.collections.List<Entity>

    @Query("SELECT * FROM Entity WHERE zonaTugas LIKE :zona")
    abstract fun findByZone(zona: String): kotlin.collections.List<Entity>

}