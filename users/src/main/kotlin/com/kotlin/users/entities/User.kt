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
    val idade: Int,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "is_active", nullable = false)
    val isActive: Boolean,

    @OneToMany(cascade = [CascadeType.ALL])
    val address: Set<Address>
    )