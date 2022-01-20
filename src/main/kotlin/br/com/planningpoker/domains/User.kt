package br.com.planningpoker.domains

import java.time.LocalDateTime

data class User (
    val id: Long? = null,
    val userName: String,
    val password: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)