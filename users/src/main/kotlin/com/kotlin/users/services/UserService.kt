package com.kotlin.users.services

import com.kotlin.users.entities.User
import com.kotlin.users.enums.Profile
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
            roles = setOf(Profile.USER),
            password = bCrypt.encode(user.password)
        )
        return userRepository.save(customerCopy)
    }

    fun findById(id: Long): User? = userRepository.findById(id).orElseThrow()

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