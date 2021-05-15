package edu.zc;

import edu.zc.dao.User2Dao;
import edu.zc.domain.User2;
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
 * @Date: 2021/05/15 - 15:45
 */
public class User2Test {

    InputStream in;
    SqlSessionFactory factory;
    SqlSession sqlSession;
    User2Dao user2Dao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        user2Dao = sqlSession.getMapper(User2Dao.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void Alias(){
        List<User2> all = user2Dao.findAll();
        for (User2 user2 :
                all) {
            System.out.println(user2);
        }
    }

    @Test
    public void Alias2(){
        User2 user = new User2();
        user.setUserName("谷歌");
        user.setPw("google");
        user.setPhone("00112233");
        user2Dao.insertOne(user);
        System.out.println("插入成功");
    }

    @Test
    public void Alias3(){
        User2 user = new User2();
        user.setUserName("优步");
        user.setPw("Uber");
        user.setPhone("778899");
        user2Dao.insertOne(user);
        System.out.println("插入成功");
    }

    @Test
    public void Alias4(){
        User2 one = user2Dao.findOne(2);
        System.out.println(one);
    }
}
