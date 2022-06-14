package com.kotlin.users.controllers;

import com.kotlin.users.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController ( private val userRepository: UserRepository ){

    @GetMapping
    fun getAll() = ResponseEntity.ok(userRepository.findAll())
}
