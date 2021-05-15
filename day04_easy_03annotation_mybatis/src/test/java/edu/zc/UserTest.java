package edu.zc;

import edu.zc.dao.UserDao;
import edu.zc.domain.User;
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
 * @Date: 2021/05/15 - 15:06
 */
public class UserTest {

    InputStream in;
    SqlSessionFactory factory;
    SqlSession sqlSession;
    UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll() {
        List<User> all = userDao.findAll();
        for (User user :
                all) {
            System.out.println(user);
        }
    }

    @Test
    public void findOne(){
        User one = userDao.findOne(2);
        System.out.println(one);
    }

    @Test
    public void insertOne(){
        User user = new User();
        user.setUsername("西安交大");
        user.setPassword("xll");
        user.setPhone("333");
        userDao.insertOne(user);
        System.out.println("插入成功");
    }

    @Test
    public void updateOne(){
        User user = new User();
        user.setId(133);
        user.setUsername("鬼怪");
        user.setPhone("3457890");
        userDao.updateOne(user);
        System.out.println("更新成功");
    }

    @Test
    public void deleteOne(){
        userDao.deleteOne(135);
        System.out.println("删除成功");
    }

}
