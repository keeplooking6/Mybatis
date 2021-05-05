package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/05 - 17:16
 */
public interface RoleDao {

    /**
     * 查询所有角色对应的用户
     */
    List<Role> findAll();

}
