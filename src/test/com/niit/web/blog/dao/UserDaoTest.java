package com.niit.web.blog.dao;

import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {
    private static Logger logger= LoggerFactory.getLogger(UserDaoTest.class);
    private UserDao userDao= DaoFactory.getUserDaoInstance();
    @Test
    public void batchInsert() {
        try {
            int[] result=userDao.batchInsert(JSoupSpider.getUsers());

        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }

    @Test
    public void selectAll() throws SQLException {
        List<User> userList = userDao.selectAll();
        System.out.println(userList.size());
    }
}