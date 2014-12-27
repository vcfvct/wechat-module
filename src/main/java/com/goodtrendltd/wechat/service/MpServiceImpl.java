package com.goodtrendltd.wechat.service;

import com.goodtrendltd.wechat.model.EventType;
import com.goodtrendltd.wechat.model.JaxbHelper;
import com.goodtrendltd.wechat.model.incoming.*;
import com.goodtrendltd.wechat.model.outgoing.OutGoingBaseMessage;
import com.goodtrendltd.wechat.model.outgoing.OutGoingMsgType;
import com.goodtrendltd.wechat.model.outgoing.OutGoingTextMessage;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by LeOn on 12/11/14.
 */
@Service
public class MpServiceImpl implements MpService
{
    /**
     * 与接口配置信息中的Token要一致
     */
    public static String TOKEN = "goodtrendltd";

    /**
     * 验证签名
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public boolean checkSignature(String signature, String timestamp, String nonce)
    {
        String[] arr = new String[]{TOKEN, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
        {
            content.append(arr[i]);
        }
        MessageDigest md;
        String tmpStr = null;

        try
        {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        // 将sha1加密后的字符串可与signature对比
        return tmpStr != null && tmpStr.equals(signature.toUpperCase());
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private String byteToStr(byte[] byteArray)
    {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++)
        {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private String byteToHexStr(byte mByte)
    {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }


    @Override
    public String handleIncomingMessage(String incomingStringMessage)
    {
        IncomingBaseMessage incomingBaseMessage = getIncomingMsg(incomingStringMessage);
        return incomingBaseMessage.getOutputMsg();
    }

    /**
     *
     * @param incomingString
     * @return the subclass of the baseMessage based on the incoming message type
     */
    private IncomingBaseMessage getIncomingMsg(String incomingString)
    {
        try
        {
            GeneralMsgForJaxb result = (GeneralMsgForJaxb) JaxbHelper.getUnmarshaller(GeneralMsgForJaxb.class).unmarshal(new StreamSource(new
                    ByteArrayInputStream(incomingString.getBytes())));
            IncomingMsgType msgType = IncomingMsgType.valueOf(result.getMsgType());
            switch (msgType)
            {
                case text:
                    return (IncomingTextMessage) JaxbHelper.getUnmarshaller(IncomingTextMessage.class).unmarshal(new StreamSource(new ByteArrayInputStream
                            (incomingString
                            .getBytes())));
                case event:
                    return (IncomingEventMessage) JaxbHelper.getUnmarshaller(IncomingEventMessage.class).unmarshal(new StreamSource(new ByteArrayInputStream
                            (incomingString
                                    .getBytes())));
                default:
                    break;
            }
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }

        return null;
    }



}
