package com.goodtrendltd.wechat.model.outgoing;

import java.util.List;

/**
 * Created by LeOn on 12/11/14.
 /**
 * 多图文消息，
 * 单图文的时候 Articles 只放一个就行了
 */
public class NewsMessageOutGoing extends OutGoingBaseMessage {
    /**
     * 图文消息个数，限制为10条以内
     */
    private int articleCount;
    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private List<Article> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
