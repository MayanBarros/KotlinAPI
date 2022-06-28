package com.kotlin.users.services

import com.kotlin.users.entities.User
import com.kotlin.users.enums.Errors
import com.kotlin.users.enums.Role
import com.kotlin.users.exceptions.NotFoundException
import com.kotlin.users.repositories.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bCrypt: BCryptPasswordEncoder
) {

    fun getAll(): List<User> = userRepository.findAll()

    fun save(user: User): User {
        val customerCopy = user.copy(
            roles = setOf(Role.USER),
            password = bCrypt.encode(user.password)
        )
        return userRepository.save(customerCopy)
    }

    fun findById(id: Long): User? = userRepository.findById(id).orElseThrow { NotFoundException(Errors.API1001.message.format(id), Errors.API1001.code) }

    fun deactivateUser(id: Long): User {
        val user = findById(id)
        user!!.isActive = false
        return save(user)
    }

    fun activateUser(id: Long): User {
        val user = findById(id)
        user!!.isActive = true
        return save(user)
    }
}