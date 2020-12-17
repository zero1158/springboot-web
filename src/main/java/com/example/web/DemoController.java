package com.example.web;

import com.example.config.IndexEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private IndexEntity entity;

    @Value("${dev.hello}")
    private String hello;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public @ResponseBody String getString(){
        return hello+","+entity.getAge()+"say:hello!";
    }

    /**
     * 使用restful风格请求
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("redis/{key}/{value}")
    public String setRedis(@PathVariable String key,
                           @PathVariable String value){
        redisTemplate.opsForValue().set(key,value);
        return "success";
    }

    /**
     * 使用restful风格的get类请求
     * @param key
     * @return
     */
    @GetMapping("redis/{key}")
    public String getRedis(@PathVariable("key") String key){
        String value = (String)redisTemplate.opsForValue().get(key);
        return "reids:"+value;
    }
}
