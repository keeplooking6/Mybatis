package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.dao.AccountUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
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
 * @author keep-looking
 * @date 2021/3/28 - 19:22
 */

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    private AccountUserDao accountUserDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        accountDao = sqlSession.getMapper(AccountDao.class);
        accountUserDao = sqlSession.getMapper(AccountUserDao.class);
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

        List<Account> all = accountDao.findAll();
        for (Account account:
             all) {
            System.out.println(account);
        }
    }

    @Test
    public void selectAllAccountUser() {

        List<AccountUser> allAccountUser = accountUserDao.findAllAccountUser();
        for (AccountUser accountUser:
                allAccountUser) {
            System.out.println(accountUser);
        }
    }

    @Test
    public void selectAll2() {

        List<Account> all = accountDao.findAll2();
        for (Account account:
                all) {
            System.out.println("------------每个account的信息-------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

//    @Test
    public void findById(){
        Account user = accountDao.findById(130);
        System.out.println(user);
    }



}
