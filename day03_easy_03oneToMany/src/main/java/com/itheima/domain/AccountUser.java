package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: keeplooking
 * @Date: 2021/05/04 - 17:45
 */

@Data
public class AccountUser extends Account{
    private String phone;

    @Override
    public String toString() {
        return super.toString()+"   AccountUser{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
