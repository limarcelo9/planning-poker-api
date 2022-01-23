package br.com.planningpoker.dto

import java.time.LocalDateTime

data class UserView(
    val id: Long? = null,
    val userName: String,
    val createdAt: LocalDateTime,
)
