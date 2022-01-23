package br.com.planningpoker.mapper

import br.com.planningpoker.domain.User
import br.com.planningpoker.dto.NewUserForm
import org.springframework.stereotype.Component

@Component
class UserFormMapper : Mapper<NewUserForm, User> {
    override fun map(t: NewUserForm): User {
        return User(
            userName = t.userName,
            password = t.password,
        )
    }
}
