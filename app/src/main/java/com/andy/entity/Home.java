package com.andy.entity;

/**
 * 首页的实体,包含首页所需要显示的内容.(单例模式)
 * <p>
 * Created by andy on 17-2-14.
 */

public class Home {
    /**
     * 首页
     */
    private Title home;

    /**
     * 文章列表(目录)
     */
    private Title articleList;

    /**
     * 照片
     */
    private Title photo;

    /**
     * 关于我
     */
    private Title aboutMe;

    /**
     * 用户名 —— 和泽书院
     */
    private String name;

    /**
     * 头像链接
     */
    private String headPhotoUrl;

    private static Home mHome;

    private Home() {

    }

    public static Home getInstance() {
        if (mHome == null) {
            mHome = new Home();
        }
        return mHome;
    }

    public Title getHome() {
        return home;
    }

    public void setHome(Title home) {
        this.home = home;
    }

    public Title getArticleList() {
        return articleList;
    }

    public void setArticleList(Title articleList) {
        this.articleList = articleList;
    }

    public Title getPhoto() {
        return photo;
    }

    public void setPhoto(Title photo) {
        this.photo = photo;
    }

    public Title getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(Title aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
    }
}
