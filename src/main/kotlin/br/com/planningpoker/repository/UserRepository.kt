package br.com.planningpoker.repository

import br.com.planningpoker.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}