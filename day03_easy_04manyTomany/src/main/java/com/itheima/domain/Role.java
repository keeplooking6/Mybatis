package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/05 - 17:15
 */

@Data
@ToString
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;

//    多对多的关系映射
    private List<User> user;

}
