package com.goodtrendltd.wechat.controller;

import com.goodtrendltd.wechat.TestRestServiceConfig;
import com.goodtrendltd.wechat.TestRestServiceWebConfig;
import com.goodtrendltd.wechat.service.MpService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by LeOn on 12/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestRestServiceConfig.class, TestRestServiceWebConfig.class})
@WebAppConfiguration
public class MpRestControllerTest
{
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    protected MpService mpServiceMock;

    @Before
    public void setup()
    {
        Mockito.reset(mpServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHandleIncoming() throws Exception
    {
        String incomingMsg = "<xml>\n" +
                "    <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "    <CreateTime>1348831860</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[this 看看消息 a test]]></Content>\n" +
                "    <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";

        when(mpServiceMock.handleIncomingMessage(incomingMsg)).thenReturn("good");

        mockMvc.perform(post("/api/mp").contentType("application/xml;charset=utf-8").content(incomingMsg)).andExpect(status().isOk());

    }
}
