package com.kotlin.users.entities

import javax.persistence.*

@Entity
@Table(name = "tb_user")
data class User (

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "age", nullable = false)
    val age: Int,

    @OneToMany(cascade = [CascadeType.ALL])
    val address: Set<Address>?,

    @Column(name = "phone_number", nullable = false)
    val phoneNumber: String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "is_active", nullable = false)
    var isActive: Boolean
    )