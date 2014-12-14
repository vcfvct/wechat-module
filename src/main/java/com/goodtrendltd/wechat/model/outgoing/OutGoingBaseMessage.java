package com.goodtrendltd.wechat.model.outgoing;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by LeOn on 12/11/14.
 */
@XmlType
public abstract class OutGoingBaseMessage {

    /**
     * 接收方帐号（收到的OpenID）
     */
    private String toUserName;
    /**
     * 开发者微信号
     */
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long createTime;

    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 位0x0001被标志时，星标刚收到的消息
     */
//    private int funcFlag;

    @XmlElement(name = "ToUserName")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    @XmlElement(name = "FromUserName")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
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
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

/*    @XmlElement(name = "FuncFlag")
    public int getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.funcFlag = funcFlag;
    }*/
}
