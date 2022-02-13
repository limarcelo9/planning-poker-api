package br.com.planningpoker.service

import br.com.planningpoker.domain.Game
import br.com.planningpoker.dto.GameView
import br.com.planningpoker.dto.NewGameForm
import br.com.planningpoker.dto.UpdateGameForm
import br.com.planningpoker.mapper.GameFormMapper
import br.com.planningpoker.mapper.GameViewMapper
import br.com.planningpoker.repository.GameRepository
import org.apache.coyote.http11.Constants.a
import org.springframework.stereotype.Service

@Service
class GameService(
    private var repository: GameRepository,
    private val gameViewMapper: GameViewMapper,
    private val gameFormMapper: GameFormMapper
) {

    fun findAll(): List<GameView> {
        return repository.findAll().map { t -> gameViewMapper.map(t) }
    }

    fun findById(id: Long): GameView {
        val game = repository.findAll().stream().filter { game ->
            game.id == id
        }.findFirst().get()
        return gameViewMapper.map(game)
    }

    fun create(form: NewGameForm) {
        val game = gameFormMapper.map(form)
        repository.save(game)
    }

    fun update(form: UpdateGameForm) {
        var game = repository.findById(form.id).get()
        if(game != null) {
            game.title = form.title
            repository.save(game)
        }
    }
}