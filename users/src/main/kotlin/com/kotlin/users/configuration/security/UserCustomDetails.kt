package com.kotlin.users.configuration.security

import com.kotlin.users.entities.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserCustomDetails(
    private val user: User
) : UserDetails {

    val id: Long = user.id!!

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = user.roles
        .map { SimpleGrantedAuthority(it.description) }
        .toMutableList()

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.id.toString()

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = user.isActive
}