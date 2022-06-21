package com.kotlin.users.dto.request

import com.kotlin.users.entities.Address
import javax.validation.constraints.NotNull

class AddressRequestDTO (

    @NotNull
    val address: String,

    @NotNull
    val number: String,

    @NotNull
    val city: String,

    @NotNull
    val state: String
    ) {

    fun toEntity(): Address {
        return Address(
            id = null,
            zipCode = generateZipCode(),
            address = this.address,
            number = this.number,
            city = this.city,
            state = this.state
        )
    }

    private fun generateZipCode(): String {
        var zipCode = ""
        for (i in 0..7) {
            val randomString = (0..9).random().toString()
            zipCode += randomString
        }
        return zipCode
    }
}