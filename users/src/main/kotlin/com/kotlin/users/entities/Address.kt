package com.kotlin.users.entities

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

    @Column(name = "address", nullable = false)
    val address: String,

    @Column(name = "number", nullable = false)
    val number: String,

    @Column(name = "city", nullable = false)
    val city: String,

    @Column(name = "state", nullable = false)
    val state: String
)