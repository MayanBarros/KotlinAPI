package com.kotlin.users.dto.response

import com.kotlin.users.entities.User

class UserResponse(
    val name: String,
    val age: Int,
    val phoneNumber: String,
    val email: String,
    val address: Collection<AddressResponse>?
) {
    companion object {
        fun from(user: User) = UserResponse(
            name = user.name,
            age = user.age,
            phoneNumber = user.phoneNumber,
            email = user.email,
            address = user.address?.map { AddressResponse.from(it) }
        )
    }
}