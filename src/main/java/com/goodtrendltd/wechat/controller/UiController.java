package com.goodtrendltd.wechat.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by LeOn on 12/14/14.
 */
@Controller
public class UiController
{
    private final static Logger logger = Logger.getLogger(UiController.class);

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView handleIndex()
    {
        logger.info("someone vistied the app at: " + new Date());
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
