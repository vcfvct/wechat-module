package com.goodtrendltd.wechat.controller;

import com.goodtrendltd.wechat.service.MpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LeOn on 12/11/14.
 */
@RestController
@RequestMapping("/api/mp")
public class MpRestController
{

    @Autowired
    MpService mpService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String handleSignature(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce,
                                  @RequestParam("echostr") String echostr)
    {
        return mpService.checkSignature(signature, timestamp, nonce) ? echostr : null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String handleIncoming(@RequestBody String incomingBaseMessage)
    {
        String result = mpService.handleIncomingMessage(incomingBaseMessage);
        return result;
    }

}
