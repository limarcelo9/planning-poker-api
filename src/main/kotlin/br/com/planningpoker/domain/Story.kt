package br.com.planningpoker.domain

import br.com.planningpoker.enums.EnumStory
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Story(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val statusStory: EnumStory = EnumStory.CREATED,
)
