package br.com.planningpoker.domain

import br.com.planningpoker.enums.EnumGame
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "GAME")
data class Game(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String,
    val createdAt: Date = Date(),
    var status: EnumGame = EnumGame.ACTIVE,

    @ManyToOne
    @JoinColumn(name = "id_user")
    val author: User
)
