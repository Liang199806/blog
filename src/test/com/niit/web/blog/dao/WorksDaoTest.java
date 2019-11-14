package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Works;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * @author Liang
 * @ClassName WorksDaoTest
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class WorksDaoTest {
    private static Logger logger= LoggerFactory.getLogger(WorksDaoTest.class);
    private WorksDao worksDao= DaoFactory.getWorksDaoInstance();
    @Test
    public void batchInsert() {
        try {
            int[] result=worksDao.batchInsert(JSoupSpider.getWork());
            System.out.println(result.length);
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }

    @Test
    public void intserts() throws SQLException {
        worksDao.intsert();
    }
}
