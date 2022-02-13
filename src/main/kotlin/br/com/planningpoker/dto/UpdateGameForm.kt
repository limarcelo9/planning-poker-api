package br.com.planningpoker.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateGameForm (
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min= 5, max = 50) val title: String
)
