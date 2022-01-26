package br.com.planningpoker.domain

import br.com.planningpoker.enums.EnumGame
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "GAME")
data class Game(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val title: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: EnumGame = EnumGame.ACTIVE,

    @ManyToOne
    @JoinColumn(name = "id_user")
    val author: User
)
