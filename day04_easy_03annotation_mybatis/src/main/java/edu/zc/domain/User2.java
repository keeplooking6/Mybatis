package edu.zc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: keeplooking
 * @Date: 2021/05/15 - 15:45
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User2 {
    private Integer userId;
    private String userName;
    private String pw;
    private String phone;
}

