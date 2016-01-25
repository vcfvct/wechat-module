package com.goodtrendltd.wechat.model.incoming;

import com.goodtrendltd.wechat.model.EventType;
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
 * Created by LeOn on 12/20/14.
 */
@XmlType
@XmlRootElement(name = "xml")
public class IncomingEventMessage extends IncomingBaseMessage
{
    /**
     * 事件类型
     */
    private String event;

    @XmlElement(name = "Event")
    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }

    /**
     * 事件内容
     */
    private String eventKey;

    @XmlElement(name = "EventKey")
    public String getEventKey()
    {
        return eventKey;
    }

    public void setEventKey(String eventKey)
    {
        this.eventKey = eventKey;
    }

    @Override
    public String getOutputMsg()
    {
        OutGoingTextMessage outGoingTextMessage = new OutGoingTextMessage();
        outGoingTextMessage.setToUserName(getFromUserName());
        outGoingTextMessage.setFromUserName(getToUserName());
        outGoingTextMessage.setCreateTime(new Date().getTime());
        outGoingTextMessage.setMsgType(OutGoingMsgType.text.name());
        EventType eventType = EventType.valueOf(getEvent());
        switch (eventType)
        {
            case subscribe:
                outGoingTextMessage.setContent("欢迎来到喜宝的公司！");
                break;
            case unsubscribe:
                //do nothing for now
                break;
            case CLICK:
                if ("V1001_GOOD".equals(eventKey))
                {
                    outGoingTextMessage.setContent("谢谢你的赞！");
                }
                break;
            default:
                //do nothing for now
                break;
        }
        StringWriter sw = new StringWriter();
        try
        {
            JaxbHelper.getMarshaller(OutGoingTextMessage.class).marshal(outGoingTextMessage, sw);
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return JaxbHelper.unEscapeBrackets(sw.toString());
    }
}
