package com.kotlin.users.exceptions

class AuthenticationException(override val message: String, val errorCode: String) : Exception()