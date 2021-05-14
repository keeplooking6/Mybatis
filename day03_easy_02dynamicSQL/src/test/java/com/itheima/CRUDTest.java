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
import java.util.ArrayList;
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
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void closeResource() throws IOException {
        //      事务提交
//        sqlSession.commit();
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
    @Test
    public void selectByCondition() {
        User u = new User();
        u.setName("wbw");
        List<User> users = userDao.findByCondition(u);
        for (User user:
                users) {
            System.out.println(user);
        }
    }

    /**
     * 根据多个id查询匹配用户
     */

    @Test
    public void selectByIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(131);
        list.add(132);
        list.add(133);
        vo.setIds(list);

        List<User> users = userDao.findByIds(vo);
        for (User user:
                users) {
            System.out.println(user);
        }
    }

}
