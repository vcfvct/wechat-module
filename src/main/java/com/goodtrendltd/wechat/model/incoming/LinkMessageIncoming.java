package com.goodtrendltd.wechat.model.incoming;

/**
 * Created by LeOn on 12/11/14.
 */
public class LinkMessageIncoming extends IncomingBaseMessage {
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息描述
     */
    private String description;
    /**
     * 消息链接
     */
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getOutputMsg()
    {
        return null;
    }
}
