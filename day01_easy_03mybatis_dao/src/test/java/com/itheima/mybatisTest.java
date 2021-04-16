package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/19 - 17:12
 */

public class mybatisTest {

    @Test
    public static void main(String[] args) throws Exception {
        //    1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//    2.创建工厂SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        UserDaoImpl userDao = new UserDaoImpl(factory);
        List<User> users = userDao.findAll();
//    5.遍历结果
        for (User user :
                users) {
            System.out.println(user);
        }
//    6.释放资源
//        session.close();
        in.close();
    }

}
