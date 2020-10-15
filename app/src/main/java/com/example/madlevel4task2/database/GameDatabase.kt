package com.example.madlevel4task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.madlevel4task2.dao.GameDao
import com.example.madlevel4task2.model.Game

@Database (entities = [Game::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase(){
    abstract fun gameDao() : GameDao

    companion object {
        private const val DATABASE_NAME = "ROCKPAPERSCISSORDATABASE"

        @Volatile
        private var gameDatabase: GameDatabase? = null

        fun getDatabase(context: Context): GameDatabase? {
            if(gameDatabase == null){
                synchronized(GameDatabase::class.java){
                    if(gameDatabase == null){
                        gameDatabase = Room.databaseBuilder(
                            context.applicationContext,
                            GameDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }

            return gameDatabase
        }
    }
}