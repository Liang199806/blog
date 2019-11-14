package com.niit.web.blog.domain;

/**
 * @author Liang
 * @ClassName WorksDto
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class WorksDto {
    private String title;
    private Long authorid;

    public WorksDto(String title, Long authorid) {
        this.title = title;
        this.authorid = authorid;
    }

    public WorksDto() {
    }
}
