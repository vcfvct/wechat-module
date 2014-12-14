package com.goodtrendltd.wechat.model.outgoing;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by LeOn on 12/13/14.
 */
public class AdapterCDATA extends XmlAdapter<String, String>
{
    @Override
    public String unmarshal(String v) throws Exception
    {
        return "<![CDATA[" + v + "]]>";
    }

    @Override
    public String marshal(String v) throws Exception
    {
        return "<![CDATA[" + v + "]]>";
    }
}
