package com.kotlin.users.services

import com.kotlin.users.configuration.security.UserCustomDetails
import com.kotlin.users.exceptions.AuthenticationException
import com.kotlin.users.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val user = userRepository.findById(id.toLong()).orElseThrow { AuthenticationException("User not found", "999") }
        return UserCustomDetails(user)
    }
}