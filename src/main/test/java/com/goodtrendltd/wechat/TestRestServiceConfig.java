package com.goodtrendltd.wechat;

import com.goodtrendltd.wechat.service.MpService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LeOn on 12/13/14.
 */
@Configuration
public class TestRestServiceConfig
{
    @Bean
    public MpService mpServiceMock()
    {
        return Mockito.mock(MpService.class);
    }
}
