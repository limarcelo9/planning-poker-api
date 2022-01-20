package br.com.planningpoker.domains

import br.com.planningpoker.enums.EnumGame
import java.time.LocalDateTime

data class Game(
    val id: Long? = null,
    val title: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: EnumGame = EnumGame.ACTIVE,
    val players: List<User> = ArrayList(),
    val stories: List<Story> = ArrayList(),
    val author: User,
)
