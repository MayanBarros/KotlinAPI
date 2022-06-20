package com.kotlin.users.dto.request

import com.kotlin.users.entities.Address
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

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
    val isActive: Boolean
        )