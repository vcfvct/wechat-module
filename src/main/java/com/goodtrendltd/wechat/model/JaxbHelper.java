package com.goodtrendltd.wechat.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by LeOn on 12/13/14.
 */
public class JaxbHelper
{

    public static Unmarshaller getUnmarshaller(Class c)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller;
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Marshaller getMarshaller(Class c)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Marshaller marshaller = jaxbContext.createMarshaller();
            return marshaller;
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String unEscapeQuotes(String input)
    {
        return input.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
    }
}
