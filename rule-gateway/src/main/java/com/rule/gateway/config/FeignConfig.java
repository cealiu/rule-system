package com.rule.gateway.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiuCe
 * @date 2020/5/23 20:34
 * @email liucemail@gmail.com
 */
@Configuration
@EnableFeignClients({"com"})
public class FeignConfig {
}
