<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.itheima.dao.UserDao" %>
<%@ page import="com.itheima.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html;charSet=UTF-8" pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World!</h2>
<%
    SqlSessionFactory factory;
    //    1.读取配置文件
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//    2.创建工厂SqlSessionFactory
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    factory = builder.build(in);
//    3.利用工厂创建SqlSession对象（执行操作）
    SqlSession sqlSession = factory.openSession();
//    4.不直接执行操作，而是使用sqlsession创建dao接口的代理对象，并用其findAll方法来操作
    UserDao userDao = sqlSession.getMapper(UserDao.class);
    List<User> users = userDao.findAll();
//    5.遍历结果
    for (User user :
            users) {
        System.out.println(user);
    }
//    6.释放资源
    sqlSession.close();
    in.close();
%>
</body>
</html>
