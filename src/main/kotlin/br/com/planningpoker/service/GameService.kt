package br.com.planningpoker.service

import br.com.planningpoker.domain.Game
import br.com.planningpoker.dto.GameView
import br.com.planningpoker.dto.NewGameForm
import br.com.planningpoker.mapper.GameFormMapper
import br.com.planningpoker.mapper.GameViewMapper
import org.springframework.stereotype.Service

@Service
class GameService(
    private var games: List<Game> = ArrayList(),
    private val gameViewMapper: GameViewMapper,
    private val gameFormMapper: GameFormMapper
) {

    fun list(): List<GameView> {
        return games.map {t -> gameViewMapper.map(t) }
    }

    fun findById(id: Long): GameView {
        val game =  games.stream().filter {
                game -> game.id == id
        }.findFirst().get()
        return gameViewMapper.map(game)
    }

        fun create(form: NewGameForm) {
            val game = gameFormMapper.map(form)
            game.id = games.size.toLong() +1
            games = games.plus(game)
    }
}