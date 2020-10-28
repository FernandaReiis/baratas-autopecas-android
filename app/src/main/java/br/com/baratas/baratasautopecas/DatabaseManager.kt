package br.com.baratas.baratasautopecas

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: BaratasDatabase

    init {
        val context = BaratasApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            BaratasDatabase::class.java,
            "baratas.sqlite"
        ).build()

    }

    fun getPartDAO(): PartDAO {
        return dbInstance.partDAO()
    }
}