package com.goodtrendltd.wechat.model.outgoing;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by LeOn on 12/11/14.
 * 文本消息
 */
@XmlType
@XmlRootElement(name = "xml")
public class OutGoingTextMessage extends OutGoingBaseMessage
{
    /**
     * 回复的消息内容
     */
    private String content;

    @XmlElement(name = "Content")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}