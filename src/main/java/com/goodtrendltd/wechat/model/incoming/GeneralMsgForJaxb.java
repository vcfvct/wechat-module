package com.goodtrendltd.wechat.model.incoming;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LeOn on 12/13/14.
 *
 * this is a convenience class for unMarshall the incoming message so that we can get the message type out of it.
 * Currently only message type is needed so it is the only field being unMarshalled.
 * we could add more if needed
 */
@XmlRootElement(name = "xml")
public class GeneralMsgForJaxb
{
    /**
     * 开发者微信号
     */
//    private String toUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
//    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
//    private long createTime;

    /**
     * 消息id，64位整型
     */
//    private long msgId;

    /**
     * 消息类型 text、image、location、link
     */
    private String msgType;

/*    @XmlElement(name = "ToUserName")
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

    @XmlElement(name = "MsgId")
    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }*/

    @XmlElement(name = "MsgType")
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

}
