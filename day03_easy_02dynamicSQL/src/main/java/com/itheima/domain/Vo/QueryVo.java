package com.itheima.domain.Vo;

import com.itheima.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author keep-looking
 * @date 2021/4/1 - 9:01
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueryVo {
    private User user;
    private List<Integer> ids;
}
