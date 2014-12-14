package com.goodtrendltd.wechat.model.incoming;

import com.goodtrendltd.wechat.model.JaxbHelper;
import com.goodtrendltd.wechat.model.outgoing.OutGoingMsgType;
import com.goodtrendltd.wechat.model.outgoing.OutGoingTextMessage;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by LeOn on 12/11/14.
 * 文本消息
 */
@XmlType
@XmlRootElement(name = "xml")
public class IncomingTextMessage extends IncomingBaseMessage
{
    /**
     * 回复的消息内容
     */
    private String content;

    @XmlElement(name = "Content")
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getOutputMsg()
    {
        OutGoingTextMessage outGoingTextMessage = new OutGoingTextMessage();
        outGoingTextMessage.setToUserName(getFromUserName());
        outGoingTextMessage.setFromUserName(getToUserName());
        outGoingTextMessage.setCreateTime(new Date().getTime());
        outGoingTextMessage.setMsgType(OutGoingMsgType.text.name());
        switch (getContent())
        {
            case "1":
                outGoingTextMessage.setContent("1, 很好第一名！");
                break;
            case "2":
                outGoingTextMessage.setContent("我真的不是2货");
                break;
            default:
                outGoingTextMessage.setContent("我不认识这个指令:(");

        }
        StringWriter sw = new StringWriter();
        try
        {
            JaxbHelper.getMarshaller(OutGoingTextMessage.class).marshal(outGoingTextMessage, sw);
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return JaxbHelper.unEscapeQuotes(sw.toString());
    }
}