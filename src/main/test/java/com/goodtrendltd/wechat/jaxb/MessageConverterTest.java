package com.goodtrendltd.wechat.jaxb;

import com.goodtrendltd.wechat.model.JaxbHelper;
import com.goodtrendltd.wechat.model.incoming.IncomingBaseMessage;
import com.goodtrendltd.wechat.model.incoming.IncomingTextMessage;
import com.goodtrendltd.wechat.model.incoming.IncomingTextMessageTemp;
import com.goodtrendltd.wechat.model.outgoing.OutGoingMsgType;
import com.goodtrendltd.wechat.model.outgoing.OutGoingTextMessage;
import com.sun.xml.internal.ws.message.jaxb.JAXBHeader;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by LeOn on 12/13/14.
 */
public class MessageConverterTest
{
    @Test
    public void testUnMarshalling()
    {
        String standardInput = "<xml>\n" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName> \n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[this is a test]]></Content>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(IncomingTextMessage.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            IncomingTextMessage result = (IncomingTextMessage) unmarshaller.unmarshal(new StreamSource(new ByteArrayInputStream(standardInput.getBytes())));
            System.out.println(result);
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testMarshalling() throws JAXBException
    {
        OutGoingTextMessage outGoingTextMessage = new OutGoingTextMessage();
        outGoingTextMessage.setContent("123");
        outGoingTextMessage.setMsgType(OutGoingMsgType.text.name());
        outGoingTextMessage.setToUserName("to");
        outGoingTextMessage.setFromUserName("from");
        outGoingTextMessage.setCreateTime(new Date().getTime());

        Marshaller marshaller = JaxbHelper.getMarshaller(OutGoingTextMessage.class);
        StringWriter sw = new StringWriter();
        marshaller.marshal(outGoingTextMessage, sw);

        String result = JaxbHelper.unEscapeQuotes(sw.toString());
        System.out.print(result);
    }
}
