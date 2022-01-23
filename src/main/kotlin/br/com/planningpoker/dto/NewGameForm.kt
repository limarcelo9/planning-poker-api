package br.com.planningpoker.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewGameForm(
    @field:NotNull val idAuthor: Long,
    @field:NotEmpty @field:Size(min = 5, max = 200)val title: String,
)
