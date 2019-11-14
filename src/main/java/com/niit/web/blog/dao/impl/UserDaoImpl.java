package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public int[] batchInsert(List<User> userList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_user (mobile,password,nickname,avatar,gender,birthday,introduction,create_time) VALUES (?,?,?,?,?,?,?,?) ";
       PreparedStatement pstmt=connection.prepareStatement(sql);
       userList.forEach(user -> {
           try {
               pstmt.setString(1, user.getMobile());
               pstmt.setString(2, user.getPassword());
               pstmt.setString(3, user.getNickname());
               pstmt.setString(4, user.getAvatar());
               pstmt.setString(5, user.getGender());
               //日期的设置，可以使用setObject
               pstmt.setObject(6, user.getBirthday());
               pstmt.setString(7, user.getIntroduction());
               pstmt.setObject(8, user.getCreateTime());
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
    public User findUserByMobile(String mobile) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE mobile = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, mobile);
        ResultSet rs = pstmt.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setMobile(rs.getString("mobile"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setAvatar(rs.getString("avatar"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday").toLocalDate());
            user.setIntroduction(rs.getString("introduction"));
            user.setAddress(rs.getString("address"));
            user.setFollows(rs.getShort("follows"));
            user.setFans(rs.getShort("fans"));
            user.setArticles(rs.getShort("articles"));
            user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
            user.setStatus(rs.getShort("status"));
        }
        return user;
    }

    @Override
    public List<User> selectAll() throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user ORDER BY id DESC";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        /*用result集合放置从数据库中得到数据，executeQuery()只对查询有用*/
        ResultSet rs = pstmt.executeQuery();
        List<User> userList = new ArrayList<>();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setMobile(rs.getString("mobile"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("avatar"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday").toLocalDate());
            user.setAddress(rs.getString("address"));
            user.setIntroduction(rs.getString("introduction"));
            user.setAddress(rs.getString("address"));
            user.setFollows(rs.getShort("follows"));
            user.setFans(rs.getShort("fans"));
            user.setArticles(rs.getShort("articles"));
            user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
            user.setStatus(rs.getShort("status"));
            /*将数据库中一个对象的数据添加到userList中，每次只加一条*/
            userList.add(user);

        }

        return userList;
    }
}
