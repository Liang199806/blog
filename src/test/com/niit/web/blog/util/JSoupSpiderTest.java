package com.niit.web.blog.util;

import com.niit.web.blog.entity.Address;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JSoupSpiderTest {

    @Test
    public void getWork() {
    }

    @Test
    public void getUsers() {
    }

    @Test
    public void getAddress() {
        List<Address> addresses = JSoupSpider.getAddresss();
        System.out.println(addresses.size());
    }
}