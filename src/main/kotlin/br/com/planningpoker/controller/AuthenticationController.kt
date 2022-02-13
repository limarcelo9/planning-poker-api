package br.com.planningpoker.controller

import br.com.planningpoker.dto.AuthenticateDto
import br.com.planningpoker.dto.Message
import br.com.planningpoker.dto.UserView
import br.com.planningpoker.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api")
class AuthenticationController(
    private val userService: UserService
) {
    @PostMapping("/auth")
    fun authenticate(@RequestBody dto: AuthenticateDto, response: HttpServletResponse): ResponseEntity<Any> {
        val user = userService.findByUserName(dto.userName)
            ?: return ResponseEntity.badRequest()
                .body(Message("user not found"));

        if (user.password != dto.password) {
            return ResponseEntity.badRequest()
                .body(Message("invalid username or password"));
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 1000)) // 1 day
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("is authenticated"))
    }

    @GetMapping("/login")
    fun login(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
        try {
            if (jwt == null) {
                return ResponseEntity.status(401)
                    .body(Message("unauthenticated"))
            }
            val body = Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(jwt).body

            return ResponseEntity.ok(userService.findById(body.issuer.toLong()))
        }catch (e: Exception){
            return ResponseEntity.status(401).body(Message("unauthenticated"))
        }
    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        var cookie = Cookie("jwt", "")
        cookie.maxAge = 0;

        response.addCookie(cookie)
        return ResponseEntity.ok(Message("logout is success"))
    }


}