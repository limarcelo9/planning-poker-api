package br.com.planningpoker.service

import br.com.planningpoker.domain.User
import br.com.planningpoker.dto.AuthenticateDto
import br.com.planningpoker.dto.Message
import br.com.planningpoker.dto.NewUserForm
import br.com.planningpoker.dto.UserView
import br.com.planningpoker.mapper.UserFormMapper
import br.com.planningpoker.mapper.UserViewMapper
import br.com.planningpoker.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
    private val repository: UserRepository,
    private val userViewMapper: UserViewMapper,
    private val userFormMapper: UserFormMapper
) {

    fun findAll(): List<UserView> {
        return repository.findAll().map { user ->
            userViewMapper.map(user)
        }
    }

    fun findById(id: Long): UserView {
        val user = repository.getById(id)
        return userViewMapper.map(user)
    }

    fun findObjById(id: Long): User {
        return repository.getById(id)
    }

    fun findByUserName(userName: String): User? {
        return repository.findByUserName(userName)
    }

    fun create(form: NewUserForm) {
        val user = userFormMapper.map(form)
        repository.save(user)
    }

    fun updateUsers(user: User) {
        repository.save(user)
    }


}
