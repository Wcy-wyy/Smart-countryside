package com.mohan.module.system.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDTO {
    private Integer current;

    private Integer limit;

    private String name;

}
