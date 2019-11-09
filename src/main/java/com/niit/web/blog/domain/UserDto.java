package com.niit.web.blog.domain;

import lombok.Data;

/**
 * @author Liang
 * @ClassName UserDto
 * @Description 用户传输对象
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
public class UserDto {
    private String mobile;
    private String password;

    public UserDto(String moblie, String password) {
        this.mobile = moblie;
        this.password = password;
    }

    public UserDto() {
    }
}
