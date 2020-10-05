package com.learn.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Zuned.Ahmed
 */

@Configuration
public class RedisConfiguration {

    @Bean
    LettuceConnectionFactory lettuceConnectionFactory(){
        return new LettuceConnectionFactory();
    }
    @Bean
    RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());
        return redisTemplate;
    }

}
