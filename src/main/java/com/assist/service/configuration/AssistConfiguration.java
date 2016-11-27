package com.assist.service.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by sindhya on 10/31/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.assist.service")
public class AssistConfiguration {
}
