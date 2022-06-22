package com.kotlin.users.dto.request

import com.kotlin.users.entities.User
import javax.validation.Valid
import javax.validation.constraints.*

class UserRequestDTO (

    @field:NotBlank
    @field:NotNull
    @field:NotEmpty
    @field:Size(min = 3)
    val name: String,

    @field:Min(18)
    @field:NotNull
    @field:Positive
    val age: Int,

    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    @field:Size(min = 10)
    val phoneNumber: String,

    @field:NotBlank
    @field:NotEmpty
    @field:Size(min = 12, max = 150)
    @field:Email
    val email: String,

    @field:NotBlank
    @field:NotNull
    @field:NotEmpty
    @field:Size(min = 8, max = 150)
    val password: String,

    @field:NotNull
    val isActive: Boolean,

    @Valid
    @field:NotNull
    val address: Set<AddressRequestDTO>
    ) {

    fun toEntity(): User {
        return User(
            id = null,
            name = this.name,
            age = this.age,
            phoneNumber = this.phoneNumber,
            email = this.email,
            password = this.password,
            isActive = this.isActive,
            address = this.address.map { it.toEntity() }
        )
    }
}