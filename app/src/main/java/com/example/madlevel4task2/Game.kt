package com.example.madlevel4task2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameTable")
data class Game(

    @ColumnInfo(name = "player_move")
    var playerMove: String,

    @ColumnInfo(name = "computer_move")
    var computerMove: String,

    @ColumnInfo(name = "result")
    var resultGame: String,

    @ColumnInfo(name = "date")
    var dateGame: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null,
)