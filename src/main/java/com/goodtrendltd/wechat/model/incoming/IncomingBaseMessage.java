package com.goodtrendltd.wechat.model.incoming;

import com.goodtrendltd.wechat.model.outgoing.OutGoingMsgType;
import com.goodtrendltd.wechat.model.outgoing.OutGoingTextMessage;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by LeOn on 12/11/14.
 * 消息基类（用户 -> 公众帐号）
 */
@XmlType
public abstract class IncomingBaseMessage {
    /**
     * 开发者微信号
     */
    private String toUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long createTime;

    /**
     * 消息类型 text、image、location、link
     */
    private String msgType;

    /**
     * 消息id，64位整型
     */
    private long msgId;
    @XmlElement(name = "ToUserName")
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    @XmlElement(name = "FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @XmlElement(name = "CreateTime")
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @XmlElement(name = "MsgType")
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @XmlElement(name = "MsgId")
    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getOutputMsg()
    {
        return null;
    }
}
