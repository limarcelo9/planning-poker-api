package br.com.planningpoker.controller

import br.com.planningpoker.dto.GameView
import br.com.planningpoker.dto.NewGameForm
import br.com.planningpoker.service.GameService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/games")
class GameController(
    private val service: GameService
) {

    @GetMapping
    fun list(): List<GameView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): GameView? {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid dto: NewGameForm) {
        service.create(dto)
    }
}