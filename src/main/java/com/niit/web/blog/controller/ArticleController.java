package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.domain.VO.ArticleVo;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.ArticleService;
import com.niit.web.blog.util.ResponseObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/article","/article/*"})
public class ArticleController extends HttpServlet {
    ArticleService articleService = ServiceFactory.getArticleServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseObject ro = new ResponseObject();
        String requestPath = req.getRequestURI().trim();

        List<Article> articleList = null;
        List<ArticleVo> articleVoList = null;
        if(requestPath.equals("/article")){
            /*查询所有文章信息*/
            articleList = articleService.listArticles();
            System.out.println("获取成功");
        }else{
            int position = requestPath.lastIndexOf("/");
            String id = requestPath.substring(position + 1);
            /*两表联查，查询用户对应的文章信息*/
            articleVoList = articleService.getHotArticles(Long.parseLong(id));
            System.out.println("加载成功");

        }

        ro.setCode(resp.getStatus());
        if(resp.getStatus()==200){
            ro.setMsg("请求成功");
        }else{
            ro.setMsg("请求失败");
        }

        if(articleList!=null) {
            ro.setData(articleList);
        }else {
            ro.setData(articleVoList);
        }
        Gson gson = new GsonBuilder().create();

        /*从response中取一个响应客户端的流对象*/
        PrintWriter out = resp.getWriter();

        /*通过out流将java代码转换为gson数据 （toJson)*/
        out.print(gson.toJson(ro));
        out.close();
    }
}
