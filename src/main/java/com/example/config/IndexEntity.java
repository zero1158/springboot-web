package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component//将此类交给spring容器管理
@ConfigurationProperties(prefix = "index")//读取配置文件中以index开头的自定义配置,并转为实体类
@Data
public class IndexEntity {

    private String name;

    private String age;

}
