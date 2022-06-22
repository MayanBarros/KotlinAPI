package com.kotlin.users.configuration.security

import com.kotlin.users.repositories.UserRepository
import com.kotlin.users.services.UserDetailsCustomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationConfiguration: AuthenticationConfiguration,
    private val userRepository: UserRepository,
    private val userDetailsCustomService: UserDetailsCustomService,
    private val jwtUtil: JwtUtil
    ) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors().and().csrf().disable()
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilter(AuthenticationFilter(authenticationConfiguration.authenticationManager, userRepository, jwtUtil))
        http.addFilter(AuthorizationFilter(authenticationConfiguration.authenticationManager, jwtUtil, userDetailsCustomService))
        http.authorizeRequests()
            .antMatchers("/swagger-ui.html/").permitAll()
            .and().authorizeRequests()
            .anyRequest().authenticated()
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncode(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}