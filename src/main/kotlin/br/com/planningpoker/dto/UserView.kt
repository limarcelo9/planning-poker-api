package br.com.planningpoker.dto

import java.time.LocalDateTime
import java.util.*

data class UserView(
    val id: Long? = null,
    val userName: String,
    val createdAt: Date,
)
