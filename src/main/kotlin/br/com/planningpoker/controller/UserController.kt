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

    @PostMapping("/auth")
    fun authenticate(@RequestBody dto: AuthenticateDto, response: HttpServletResponse): ResponseEntity<Any>{
        val user = service.findByUserName(dto.userName)
            ?:  return ResponseEntity.badRequest()
                .body(Message("user not found"));

        if(user.password != dto.password) {
            return ResponseEntity.badRequest()
                .body(Message("invalid username or password"));
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 1 day
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("is logged"))
    }
}