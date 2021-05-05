package com.itheima;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
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
 * @Date: 2021/05/05 - 17:24
 */
public class RoleTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession sqlSession;
    RoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void cloneResource() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void selectAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role :
                roles) {
            System.out.println(role);
        }
    }
}
