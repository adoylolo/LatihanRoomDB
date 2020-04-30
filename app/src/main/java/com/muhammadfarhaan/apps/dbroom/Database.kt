package com.muhammadfarhaan.apps.dbroom

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Entity::class), version = 1)
abstract class Database : RoomDatabase(){

    abstract fun aktivisDao(): Dao

}