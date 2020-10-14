package com.example.madlevel4task2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GameRockPaperScissorsRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "ROCK_PAPER_SCISSORS_DATABASE"

        @Volatile
        private var gameRockPaperScissorsRoomDatabaseInstance: GameRockPaperScissorsRoomDatabase? = null

        fun getDatabase(context: Context): GameRockPaperScissorsRoomDatabase? {
            if (gameRockPaperScissorsRoomDatabaseInstance == null) {
                synchronized(GameRockPaperScissorsRoomDatabase::class.java) {
                    if (gameRockPaperScissorsRoomDatabaseInstance == null) {
                        gameRockPaperScissorsRoomDatabaseInstance =
                            Room.databaseBuilder(context.applicationContext,GameRockPaperScissorsRoomDatabase::class.java, DATABASE_NAME).build()
                    }
                }
            }
            return gameRockPaperScissorsRoomDatabaseInstance
        }
    }

}