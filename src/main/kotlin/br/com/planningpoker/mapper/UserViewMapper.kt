package br.com.planningpoker.mapper

import br.com.planningpoker.domain.User
import br.com.planningpoker.dto.UserView
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserViewMapper: Mapper<User, UserView> {
    override fun map(u: User): UserView {
        return UserView(
            id = u.id,
            userName = u.userName,
            createdAt = u.createdAt,
        )}
}


