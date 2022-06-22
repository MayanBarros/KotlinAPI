package com.kotlin.users.entities

import com.kotlin.users.enums.Role
import org.hibernate.Hibernate
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
    val address: Collection<Address>?,

    @Column(name = "phone_number", nullable = false)
    val phoneNumber: String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "is_active", nullable = false)
    var isActive: Boolean,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")])
    var roles: Set<Role> = setOf()
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , age = $age , phoneNumber = $phoneNumber , email = $email , password = $password , isActive = $isActive , roles = $roles )"
    }
}