package br.com.planningpoker.services

import br.com.planningpoker.domains.Game
import br.com.planningpoker.domains.User
import br.com.planningpoker.dtos.NewGameDto
import org.springframework.stereotype.Service

@Service
class GameService(
    private var games: List<Game> = ArrayList(),
    private val userService: UserService
) {

    fun list(): List<Game> {
        return games
    }

    fun findById(id: Long): Game? {
        return games.find { game -> game.id == id  }
    }

    fun create(dto: NewGameDto) {
        games = games.plus(Game(
            id = games.size.toLong() +1,
            title = dto.title,
            author = userService.findById(dto.idAuthor)!!
        ))
    }
}