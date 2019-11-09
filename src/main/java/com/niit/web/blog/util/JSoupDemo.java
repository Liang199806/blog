package com.niit.web.blog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName JSoupDemo
 * @Description TODO
 * @Date 1:30 2019/11/6
 * @Version 1.0
 **/
public class JSoupDemo {
    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
            Elements divs = doc.getElementsByClass("col-xs-8");
            System.out.println(divs.size());
            divs.forEach(div -> {
                Elements links = div.children().first().children().first().children();
                Element element = links.get(1);
                System.out.println(element.text());
                Element img = links.get(0);
                System.out.println("https:"+img.attr("src"));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}