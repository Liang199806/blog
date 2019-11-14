package com.niit.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Liang
 * @ClassName Works
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/

@Data
public class Works {
    private Long id;
    private String title;
    private String content;
    private String picture;
    private Integer authorid;
    private Integer comments;
    private Integer like;
    private LocalDateTime releasetime;
}
