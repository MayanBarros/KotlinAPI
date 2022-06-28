package com.kotlin.users.exceptions

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}