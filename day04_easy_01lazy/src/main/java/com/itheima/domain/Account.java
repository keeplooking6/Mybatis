package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: keeplooking
 * @Date: 2021/05/04 - 16:41
 */

@Data
@ToString
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
//    从表实体中应该包含一个主表实体的对象引用
    private User user;
}
