package br.com.planningpoker.dto


import java.time.LocalDateTime
import java.util.*


data class GameView(
    val id: Long?,
    val title: String,
    val status: String,
    val createdAt: Date,
    val idAuthor: String
)


