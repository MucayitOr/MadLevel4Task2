package com.example.madlevel4task2

import android.content.Context

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRockPaperScissorsRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun getAllGames(): List<Game> {
        return gameDao.getAllGames()
    }

    suspend fun insertProduct(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteProduct(game: Game) {
        gameDao.deleteGame(game)
    }

    suspend fun deleteAllGames() {
        gameDao.deleteAllGames()
    }

}