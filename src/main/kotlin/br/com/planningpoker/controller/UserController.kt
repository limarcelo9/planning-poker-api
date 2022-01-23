package br.com.planningpoker.controller

import br.com.planningpoker.domain.User
import br.com.planningpoker.dto.NewUserForm
import br.com.planningpoker.dto.UserView
import br.com.planningpoker.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val service: UserService
) {

    @GetMapping
    fun findAll(): List<UserView> {
        return service.findAll();
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): UserView {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody form: NewUserForm) {
        return service.create(form)
    }

//    @PostMapping("/auth")
//    fun authenticate(@RequestBody dto: AuthenticateDto): User?{
//        return service.auth(dto)
//    }
}