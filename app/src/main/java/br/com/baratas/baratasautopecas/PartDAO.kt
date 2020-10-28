package br.com.baratas.baratasautopecas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PartDAO {
    @Query("SELECT * FROM part where id = :id")
    fun getById(id: Long) : Part?

    @Query("SELECT * FROM part")
    fun findAll(): List<Part>

    @Insert
    fun insert(disciplina: Part)

    @Delete
    fun delete(disciplina: Part)
}