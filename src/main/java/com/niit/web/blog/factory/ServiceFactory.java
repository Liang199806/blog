package com.niit.web.blog.factory;

import com.niit.web.blog.service.UserService;
import com.niit.web.blog.service.impl.UserServiceImpl;

/**
 * @author Liang
 * @ClassName ServiceFactory
 * @Description TODO
 * @Date 2019/11/5
 * @Version 1.0
 **/
public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }

}
