package br.com.baratas.baratasautopecas

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Part::class), version = 1)
abstract class BaratasDatabase: RoomDatabase() {
    abstract fun partDAO(): PartDAO
}