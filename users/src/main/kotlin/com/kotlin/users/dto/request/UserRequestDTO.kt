package com.kotlin.users.dto.request

import com.kotlin.users.entities.User
import javax.validation.Valid
import javax.validation.constraints.*

class UserRequestDTO (

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 3)
    val name: String,

    @Min(18)
    @NotNull
    @Positive
    val age: Int,

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 12)
    val phoneNumber: String,

    @NotBlank
    @NotEmpty
    @Size(min = 12, max = 150)
    val email: String,

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 150)
    val password: String,

    @NotNull
    val isActive: Boolean,

    @Valid
    @NotNull
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