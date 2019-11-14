package com.niit.web.blog.factory;

import com.niit.web.blog.dao.AddressDao;
import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.dao.WorksDao;
import com.niit.web.blog.dao.impl.AddressDaoImpl;
import com.niit.web.blog.dao.impl.UserDaoImpl;
import com.niit.web.blog.dao.impl.WorksDaoImpl;
import com.niit.web.blog.entity.Works;

public class DaoFactory {
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
    public static WorksDao getWorksDaoInstance(){
        return new WorksDaoImpl();
    }
    public static AddressDao getAddressDaoInstance(){
        return new AddressDaoImpl();
    }
}
