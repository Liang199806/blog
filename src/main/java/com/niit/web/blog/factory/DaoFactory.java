package com.niit.web.blog.factory;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.dao.impl.UserDaoImpl;

public class DaoFactory {
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
}
