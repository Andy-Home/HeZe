package com.andy.entity;

/**
 * 包含标题与网络跳转链接的实体类
 * <p>
 * Created by andy on 17-2-14.
 */

public class Title {
    private String title;
    private String link;

    /**
     * 构造函数
     *
     * @param title 标题
     * @param link  跳转链接
     */
    public Title(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
