package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {

    int[] batchInsert(List<Address> addressList)throws SQLException;



}
