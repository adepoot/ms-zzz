package com.antondepoot.zzz.web.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableConfigurationProperties({WebProperties.class})
public class WebConfig implements WebMvcConfigurer {

    private final WebProperties webProperties;

    public WebConfig(WebProperties webProperties) {
        this.webProperties = webProperties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] allowedOrigins = webProperties.getAllowedOrigins().size() > 0 ?
                webProperties.getAllowedOrigins().toArray(new String[0]) :
                new String[]{"*"};

        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins);
    }
}
