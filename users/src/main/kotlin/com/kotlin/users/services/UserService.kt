package com.kotlin.users.services

import com.kotlin.users.entities.User
import com.kotlin.users.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getAll(): List<User> = userRepository.findAll()

    fun save(user: User): User = userRepository.save(user)

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