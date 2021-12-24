package com.mohan.module.auth.area.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class SysArea {
    private String id;
    private String area;
    private String area_code;
    private String parent_area_code;
    private Integer status;
    private Integer deleted;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private String create_user;
    private String update_user;
}
