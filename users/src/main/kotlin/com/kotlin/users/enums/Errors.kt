package com.kotlin.users.enums

enum class Errors(val code: String, val message: String) {
    API1001("User [%s] not exist", "API-0007")
}