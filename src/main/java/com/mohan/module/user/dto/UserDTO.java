package com.mohan.module.user.dto;

import com.mohan.module.user.domain.User;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.management.relation.Role;

@Data
@Accessors(chain = true)
public class UserDTO {
    private User user;

    private Role role;

}
