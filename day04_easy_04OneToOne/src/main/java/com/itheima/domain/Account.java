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
//    多对一（mybatis中也叫做一对一）的映射
    private User user;
}
