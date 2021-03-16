package com.laoliu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.laoliu.spring5"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {

}
