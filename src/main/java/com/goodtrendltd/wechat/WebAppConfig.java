package com.goodtrendltd.wechat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by LeOn on 11/30/14.
 *
 * Extend the "WebMvcConfigurerAdapter" to override the configureMessageConverters so that we could add a custom stringHttpMessageConverter which uses UTF-8
 * because by default it uses iso-8859 something. THis way we could display the Chinese chars correctly.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.goodtrendltd.wechat.controller"})
public class WebAppConfig extends WebMvcConfigurerAdapter
{
    @Bean
    public UrlBasedViewResolver getUrlBasedViewResolver() {
        UrlBasedViewResolver u = new UrlBasedViewResolver();
        u.setPrefix("/WEB-INF/jsp/");
        u.setSuffix(".jsp");
        u.setViewClass(JstlView.class);
        return u;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverter());
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

}
