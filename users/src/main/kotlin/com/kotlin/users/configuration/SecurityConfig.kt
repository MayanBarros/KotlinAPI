package com.kotlin.users.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig {

    @Bean
    fun bCryptPasswordEncode(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}