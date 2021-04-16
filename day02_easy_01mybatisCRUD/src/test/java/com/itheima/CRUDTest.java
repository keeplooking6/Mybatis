package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.Vo.QueryVo;
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
 * @author keep-looking
 * @date 2021/3/28 - 19:22
 */

public class CRUDTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void closeResource() throws IOException {
        //      事务提交
        sqlSession.commit();
        sqlSession.close();
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
        user.setName("wbw");
        user.setPassword("wxl");
        //执行保存方法
        userDao.save(user);
    }

    @Test
    public void update(){
        User user = new User();
//        user.setId(1);
        user.setName("wxl098");
        user.setPassword("wxlxl");
        userDao.update(user);
    }

    @Test
    public void delete(){
//        User user = new User();

        userDao.delete(1);
    }

    @Test
    public void findById(){
        User user = userDao.findById(130);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        List<User> users = userDao.findByName("w");
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
        user.setName("wbw5555");
        user.setPassword("wxl6666");
        System.out.println("插入前"+user);
        //执行保存方法
        userDao.save(user);
        System.out.println("插入后"+user);
    }

    /**
     * 使用vo对象作为查询条件
     */
    @Test
    public void selectUserVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setName("%w%");
        vo.setUser(user);
        List<User> users = userDao.queryVo(vo);
        for (User u :
                users) {
            System.out.println(u);
        }
    }

}
