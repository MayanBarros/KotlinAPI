package com.kotlin.users.exceptions

data class ErrorResponse(
    val httpCode: Int,
    val message: String,
    val internalCode: String?,
    val errors: List<FieldErrorResponse>?
)