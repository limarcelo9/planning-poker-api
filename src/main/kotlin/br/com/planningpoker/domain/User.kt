package br.com.planningpoker.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "User")
data class User (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val userName: String,
    val password: String,
    var isAuth: Boolean = false,
    var lastAuth: LocalDateTime? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)