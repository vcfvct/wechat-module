package com.goodtrendltd.wechat.model.outgoing;

/**
 * Created by LeOn on 12/11/14.
 /**
 * 音乐消息
 */
public class Music {
    /**
     * 音乐名称
     */
    private String title;

    /**
     * 音乐描述
     */
    private String description;

    /**
     * 音乐链接
     */
    private String musicUrl;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    private String hQMusicUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String gethQMusicUrl() {
        return hQMusicUrl;
    }

    public void sethQMusicUrl(String musicUrl) {
        hQMusicUrl = musicUrl;
    }

}
