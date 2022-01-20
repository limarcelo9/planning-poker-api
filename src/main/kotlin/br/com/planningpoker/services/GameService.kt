package br.com.planningpoker.services

import br.com.planningpoker.domains.Game
import br.com.planningpoker.domains.User
import org.springframework.stereotype.Service

@Service
class GameService(
    private var games: List<Game> = ArrayList(),
) {

    fun list(): List<Game> {
        return games
    }

    fun findById(id: Long): Game? {
        return games.find { game -> game.id == id  }
    }

    fun create(game: Game) {
        games.plus(game)
    }
}