package com.goodtrendltd.wechat.controller;

import com.goodtrendltd.wechat.service.MpService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by LeOn on 12/11/14.
 *
 * With RestController, we have @ResponseBody by default.
 */
@RestController
@RequestMapping("/api/mp")
public class MpRestController
{
    private final static Logger logger = Logger.getLogger(MpRestController.class);


    @Autowired
    MpService mpService;

    @RequestMapping(method = RequestMethod.GET)
    public String handleSignature(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce,
                                  @RequestParam("echostr") String echostr)
    {
        return mpService.checkSignature(signature, timestamp, nonce) ? echostr : null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleIncoming(@RequestBody String incomingBaseMessage)
    {
        logger.debug("Received incoming message: '"+incomingBaseMessage + "' at: " + new Date());
        String result = mpService.handleIncomingMessage(incomingBaseMessage);
        logger.debug("Return outgoing message: '" + result + "' at: " + new Date());
        return result;
    }

}
