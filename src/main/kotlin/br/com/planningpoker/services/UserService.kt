package br.com.planningpoker.services

import br.com.planningpoker.domains.User
import org.springframework.stereotype.Service

@Service
class UserService(
    var users: List<User> = ArrayList(),
) {

    init {
        val user = User(
            id = 1,
            userName = "admin",
            password = "123456"
        )
        users = users.plus(user)
    }

    fun findById(id: Long): User? {
        return users.find { user -> user.id == id  }
    }

}
