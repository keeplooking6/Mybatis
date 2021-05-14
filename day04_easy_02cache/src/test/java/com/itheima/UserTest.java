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
    private SqlSessionFactory factory;

    @Before
    public void before() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
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
        System.out.println("-------------每个用户及其所拥有的账号信息-------------");
        List<User> all = userDao.findAll();
        for (User user :
                all) {
            System.out.println(user);
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void selectCacheLevel(){
        User user1 = userDao.findById(2);
        System.out.println(user1);

//        sqlSession.close();
//        sqlSession = factory.openSession();

        sqlSession.clearCache();
        userDao = sqlSession.getMapper(UserDao.class);

        User user2 = userDao.findById(2);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    @Test
    public void clearCache(){
        User user1 = userDao.findById(2);
        System.out.println(user1);

        user1.setUsername("littleCute");
        user1.setPhone("00000");
        userDao.updateUser(user1);

        User user2 = userDao.findById(2);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

}
