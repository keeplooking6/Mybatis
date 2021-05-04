package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author keep-looking
 * @date 2021/3/28 - 19:00
 */

@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String phone;
}
