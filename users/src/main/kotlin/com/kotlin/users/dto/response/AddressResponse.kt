package com.kotlin.users.dto.response

import com.kotlin.users.entities.Address
import org.hibernate.Hibernate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


data class AddressResponse (
    val zipCode: String,
    val address: String,
    val number: String,
    val city: String,
    val state: String
) {
    companion object {
        fun from(address: Address) = AddressResponse(
            zipCode = address.zipCode,
            address = address.address,
            number = address.number,
            city = address.city,
            state = address.state
        )
    }
}