package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

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

//    每个用户的所拥有的全部账户信息
//    一对多关系映射：主表实体应该包含从表实体的集合引用
    private List<Account> account;
}
