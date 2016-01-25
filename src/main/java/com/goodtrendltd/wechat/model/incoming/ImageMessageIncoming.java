package com.goodtrendltd.wechat.model.incoming;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by LeOn on 12/11/14.
 */
public class ImageMessageIncoming extends IncomingBaseMessage {

    private String picUrl;

    @XmlElement(name = "PicUrl")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String getOutputMsg()
    {
        return null;
    }
}
