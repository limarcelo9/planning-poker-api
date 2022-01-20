package br.com.planningpoker.controllers

import br.com.planningpoker.domains.Game
import br.com.planningpoker.dtos.NewGameDto
import br.com.planningpoker.services.GameService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/games")
class GameController(
    private val service: GameService
) {

    @GetMapping
    fun list(): List<Game>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Game? {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody dto: NewGameDto){
       service.create(dto)
    }
}