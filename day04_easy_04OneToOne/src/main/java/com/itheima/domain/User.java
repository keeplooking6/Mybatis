package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/28 - 19:00
 */

@Data
@ToString
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phone;

//  一对多：
    private List<Account> account;
}
