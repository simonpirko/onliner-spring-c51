package org.onliner.spring.c51.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("org.onliner.spring.c51")
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

}
