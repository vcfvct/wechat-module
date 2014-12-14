package com.goodtrendltd.wechat;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by LeOn on 12/13/14.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.goodtrendltd.wechat.controller")
public class TestRestServiceWebConfig extends WebMvcConfigurerAdapter
{
}
