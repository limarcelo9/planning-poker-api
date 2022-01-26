package br.com.planningpoker.repository

import br.com.planningpoker.domain.Game
import org.springframework.data.jpa.repository.JpaRepository


interface GameRepository : JpaRepository<Game, Long> {
}