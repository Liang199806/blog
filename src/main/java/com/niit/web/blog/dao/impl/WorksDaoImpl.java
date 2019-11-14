package com.niit.web.blog.dao.impl;

/**
 * @author Liang
 * @ClassName WokesDaoImpl
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/



import com.niit.web.blog.dao.WorksDao;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.entity.Works;
import com.niit.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class WorksDaoImpl implements WorksDao {

    @Override
    public int[] batchInsert(List<Works> worksList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_works (title,content,picture,authorid,comments,like_account ,releasetime) VALUES (?,?,?,?,?,?,?) ";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        worksList.forEach(works -> {
            try {
                pstmt.setString(1, works.getTitle());
                pstmt.setString(2, works.getContent());
                pstmt.setString(3, works.getPicture());
                pstmt.setInt(4, works.getAuthorid());
                //日期的设置，可以使用setObject
                pstmt.setInt(5, works.getComments());
                pstmt.setInt(6, works.getLike());
                pstmt.setObject(7, works.getReleasetime());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        int[] result=pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null,pstmt,connection);
        return result;
    }

    @Override
    public void intsert() throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_works (id,title,content,picture,authorid,comments,like_account ,releasetime) VALUES (?,?,?,?,?,?,?,?) ";
        PreparedStatement pstmt=connection.prepareStatement(sql);
                  pstmt.setLong(1,2);
                pstmt.setString(2, "123");
                pstmt.setString(3,"123");
                pstmt.setString(4, "123");
                pstmt.setInt(5, 123);
                //日期的设置，可以使用setObject
                pstmt.setInt(6,123);
                pstmt.setInt(7, 123);
                pstmt.setObject(8, LocalDateTime.now());
                pstmt.executeUpdate();
        connection.commit();
        DbUtil.close(null,pstmt,connection);
    }
}
