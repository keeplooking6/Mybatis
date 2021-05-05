package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/05 - 14:07
 */
public class UserTest {
    private SqlSession sqlSession;
    private InputStream in;
    private UserDao userDao;

    @Before
    public void before() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void selectAll() {

        List<User> all = userDao.findAll();
        for (User user :
                all) {
            System.out.println("-------------每个用户及其所拥有的角色信息-------------");
            System.out.println(user);
        }
    }
}
