package com.example.madlevel4task2.model

import androidx.room.*

@Entity(tableName = "game_table")
data class Game(
    @ColumnInfo(name="date")
    var data: String,

    @ColumnInfo(name="player_set")
    var player_movement: String,

    @ColumnInfo(name="cpu_set")
    var cpu_movement: String,

    @ColumnInfo(name="result")
    var result_of_game: String,

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
)