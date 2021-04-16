package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/28 - 19:22
 */
public class CRUDTest {
    private InputStream in;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void closeResource() throws IOException {
        in.close();
    }

    @Test
    public void selectAll() {

        List<User> users = userDao.findAll();
        for (User user:
             users) {
            System.out.println(user);
        }
    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("wbw7");
        user.setPassword("wxl8888");
        //执行保存方法
        userDao.save(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(2);
        user.setUsername("wxl");
        user.setPassword("wbw");
        userDao.update(user);
    }

    @Test
    public void delete(){
//        User user = new User();

        userDao.delete(137);
    }

    @Test
    public void findById(){
        User user = userDao.findById(132);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        List<User> users = userDao.findByName("%w%");
        for (User user:
            users) {
            System.out.println(user);
        }
    }

    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void saveUser2(){
        User user = new User();
        user.setUsername("wbw5555");
        user.setPassword("wxl6666");
        System.out.println("插入前"+user);
        //执行保存方法
        userDao.save(user);
        System.out.println("插入后"+user);
    }


}
