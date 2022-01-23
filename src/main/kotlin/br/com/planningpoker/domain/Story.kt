package br.com.planningpoker.domain

import br.com.planningpoker.enums.EnumStory
import java.time.LocalDateTime

data class Story (
    val id: Long? = null,
    val description: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val statusStory: EnumStory = EnumStory.CREATED,

    )
