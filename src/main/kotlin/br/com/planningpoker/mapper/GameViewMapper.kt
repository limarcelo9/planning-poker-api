package br.com.planningpoker.mapper

import br.com.planningpoker.domain.Game
import br.com.planningpoker.dto.GameView
import org.springframework.stereotype.Component

@Component
class GameViewMapper : Mapper<Game, GameView> {
    override fun map(t: Game): GameView {
        return GameView(
            id = t.id,
            title = t.title,
            createdAt = t.createdAt,
            status = t.status.name,
            idAuthor = t.author.id.toString()
        )
    }
}