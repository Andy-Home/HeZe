package com.andy.net;

import com.andy.entity.Home;
import com.andy.entity.Title;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 首页的网络请求
 * <p>
 * Created by andy on 17-2-14.
 */

public class HomeRequest implements Command {

    /**
     * 首页实例变量
     */
    private Home mHome = null;

    @Override
    public void run() {
        try {
            Document doc = Jsoup.connect("http://blog.sina.com.cn/sophiagoodness").get();
            Elements elements = doc.select("div.blognavInfo");

            mHome = new Home();
            //设置主要标题
            for (Element a : elements.select("a")) {
                String url = a.attr("href");
                String title = a.text();
                Title mTitle = new Title(title, url);
                switch (title) {
                    case "首页":
                        mHome.setHome(mTitle);
                        break;
                    case "博文目录":
                        mHome.setArticleList(mTitle);
                        break;
                    case "图片":
                        mHome.setPhoto(mTitle);
                        break;
                    case "关于我":
                        mHome.setAboutMe(mTitle);
                        break;
                }
            }

            //设置头像和名字
            Elements elements1 = doc.select("div.info_img");
            Element img = elements1.select("img").first();
            String headUrl = img.attr("real_src");
            String userName = img.attr("title");
            mHome.setHeadPhotoUrl(headUrl);
            mHome.setName(userName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
