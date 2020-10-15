package com.example.madlevel4task2.dao

import androidx.room.*
import com.example.madlevel4task2.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM game_table")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM game_table")
    suspend fun deleteAllGames()
}