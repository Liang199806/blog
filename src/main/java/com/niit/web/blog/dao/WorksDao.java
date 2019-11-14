package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Works;

import java.sql.SQLException;
import java.util.List;

public interface WorksDao {

    int[] batchInsert(List<Works> worksList)throws SQLException;

   public void intsert()throws SQLException;

}

