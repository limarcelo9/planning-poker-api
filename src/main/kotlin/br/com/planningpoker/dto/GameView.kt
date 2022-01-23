package br.com.planningpoker.dto


import java.time.LocalDateTime

data class GameView(
    val id: Long?,
    val title: String,
    val status: String,
    val createdAt: LocalDateTime,
    val idAuthor: String
)


