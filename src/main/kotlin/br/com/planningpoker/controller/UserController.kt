package br.com.planningpoker.controller

import br.com.planningpoker.domain.User
import br.com.planningpoker.dto.AuthenticateDto
import br.com.planningpoker.dto.Message
import br.com.planningpoker.dto.NewUserForm
import br.com.planningpoker.dto.UserView
import br.com.planningpoker.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

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

}