package br.com.planningpoker.service

import br.com.planningpoker.domain.User
import br.com.planningpoker.dto.NewUserForm
import br.com.planningpoker.dto.UserView
import br.com.planningpoker.mapper.GameFormMapper
import br.com.planningpoker.mapper.UserFormMapper
import br.com.planningpoker.mapper.UserViewMapper
import br.com.planningpoker.repository.UserRepository
import org.springframework.stereotype.Service

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

//    fun findByName(userName: String): User? {
//        return repository.findByName(userName)
//    }

    fun create(form: NewUserForm) {
        val user = userFormMapper.map(form)
        user.id = findAll().size.toLong() +1
        repository.save(user)
    }

//    fun updateUsers(user: User) {
//        repository.save(user)
//    }

//    fun auth(dto: AuthenticateDto): User? {
//        val user: User? = findByName(dto.userName)
//        if(user?.password === dto.password){
//            user?.isAuth = true
//            user?.lastAuth = LocalDateTime.now();
//            repository.save(user)
//        } else {
//            user?.isAuth = false
//        }
//        return user
//    }

}
