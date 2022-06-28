package com.kotlin.users.controllers;

import com.kotlin.users.dto.request.UserRequestDTO
import com.kotlin.users.dto.response.UserResponse
import com.kotlin.users.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/users")
class UserController (
    private val userService: UserService
){

    @GetMapping
    fun getAllUsers() = userService.getAll()
        .map { UserResponse.from(it) }
        .let { ResponseEntity.ok().body(it) }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody @Valid requestUser: UserRequestDTO): UserResponse {
        return userService.save(requestUser.toEntity())
            .let { UserResponse.from(it) }
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getUserById(@PathVariable id: Long): UserResponse? {
        return userService.findById(id)
            .let { UserResponse.from(it!!) }
    }

    @PatchMapping("{id}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deactivateUser(@PathVariable id: Long) {
        userService.deactivateUser(id)
    }

    @PatchMapping("{id}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun activeUser(@PathVariable id: Long) {
        userService.activateUser(id)
    }
}
