package br.com.planningpoker.mapper

import br.com.planningpoker.domain.Game
import br.com.planningpoker.dto.NewGameForm
import br.com.planningpoker.service.UserService
import org.springframework.stereotype.Component

@Component
class GameFormMapper(
    private val userService: UserService,
    private val userFormMapper: UserFormMapper
): Mapper<NewGameForm, Game>
     {
    override fun map(t: NewGameForm): Game {
        return Game(
            title = t.title,
            author = userService.findObjById(t.idAuthor)!!
        )
    }
}
