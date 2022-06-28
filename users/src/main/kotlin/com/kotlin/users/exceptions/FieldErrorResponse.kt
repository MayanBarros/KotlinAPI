package com.kotlin.users.exceptions

data class FieldErrorResponse(
    val message: String,
    val field: String
)