package com.kotlin.users.configuration.security

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.kotlin.users.dto.request.LoginRequest
import com.kotlin.users.dto.response.LoginResponse
import com.kotlin.users.exceptions.AuthenticationException
import com.kotlin.users.repositories.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(
    authenticationManager: AuthenticationManager,
    private val userRepository: UserRepository,
    private val jwtUtil: JwtUtil
) : UsernamePasswordAuthenticationFilter(authenticationManager) {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        try {
            val loginRequest = jacksonObjectMapper().readValue(request.inputStream, LoginRequest::class.java)
            val id = userRepository.findByEmail(loginRequest.email)?.id
            val authToken = UsernamePasswordAuthenticationToken(id, loginRequest.password)
            return authenticationManager.authenticate(authToken)
        } catch (ex: Exception) {
            throw AuthenticationException("Authentication failed", "999")
        }
    }

    override fun successfulAuthentication(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain, authResult: Authentication) {
        val id = (authResult.principal as UserCustomDetails).id
        response.addHeader("Authorization", "Bearer ${jwtUtil.generateToken(id)}")
        val loginResponse = LoginResponse("Bearer ${jwtUtil.generateToken(id)}")
        //response.writer.write(Gson().toJson(loginResponse));
        response.writer.write(loginResponse.token)
        response.writer.flush();
    }
}