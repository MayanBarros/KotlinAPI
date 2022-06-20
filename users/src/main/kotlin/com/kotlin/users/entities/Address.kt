package com.kotlin.users.entities

import org.hibernate.Hibernate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_address")
data class Address (

    @Id
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "zip_code", nullable = false)
    val zipCode: String,


    @Column(name = "address", nullable = false)
    val address: String,

    @Column(name = "number", nullable = false)
    val number: String,

    @Column(name = "city", nullable = false)
    val city: String,

    @Column(name = "state", nullable = false)
    val state: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Address

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , zipCode = $zipCode , address = $address , number = $number , city = $city , state = $state )"
    }
}