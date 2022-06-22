package com.kotlin.users.dto.request

data class LoginRequest(
    val email: String,
    val password: String
)