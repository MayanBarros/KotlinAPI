package com.kotlin.users.mapper

import com.kotlin.users.dto.request.UserRequestDTO
import com.kotlin.users.entities.User
import org.mapstruct.Mapper

@Mapper
interface UserMapper {
    fun toEntity(requestUser: UserRequestDTO): User
}