package com.niit.web.blog.dao;

import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AddressDaoTest {
    private static Logger logger= LoggerFactory.getLogger(AddressDaoTest.class);
    private AddressDao addressDao= DaoFactory.getAddressDaoInstance();
    @Test
    public void batchInsert() {
        try {
            int[] result=addressDao.batchInsert(JSoupSpider.getAddresss());
            System.out.println(result.length);
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }
}