package com.laoliu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

import java.security.Provider;

@Configuration //作为配置类,替代xml配置文件
@ComponentScan(basePackages = {"com.laoliu.spring5"},
               includeFilters = {@ComponentScan.Filter(type =
                       FilterType.ANNOTATION,classes = Service.class)},
               excludeFilters = {@ComponentScan.Filter(type =
                       FilterType.ANNOTATION,classes = Service.class)}
)   //开启组件扫描，并设置过滤规则

public class Spring5Config1 {
}
