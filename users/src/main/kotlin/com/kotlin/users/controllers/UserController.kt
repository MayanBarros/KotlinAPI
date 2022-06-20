package com.kotlin.users.controllers;

import com.kotlin.users.dto.request.UserRequestDTO
import com.kotlin.users.mapper.UserMapper
import com.kotlin.users.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/users/")
class UserController (
    private val userService: UserService,
    private val userMapper: UserMapper
){

    @GetMapping
    fun getAllUsers() = ResponseEntity.ok(userService.getAll())

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody @Valid requestUser: UserRequestDTO) {
        val toEntityUser = userMapper.toEntity(requestUser)
        userService.save(toEntityUser)
    }

    @GetMapping("{id}")
    fun getUserById(@PathVariable id: Long) {
        ResponseEntity.ok(userService.findById(id))
    }

    @PatchMapping("{id}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deactivateUser(@PathVariable id: Long) {
        ResponseEntity.ok(userService.deactivateUser(id))
    }

    @PatchMapping("{id}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun activeUser(@PathVariable id: Long) {
        ResponseEntity.ok(userService.activateUser(id))
    }
}
