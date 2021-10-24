package com.antondepoot.zzz;

import com.antondepoot.zzz.services.AppProperties;
import com.antondepoot.zzz.web.config.WebProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({AppProperties.class, WebProperties.class})
@SpringBootApplication
public class ZzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzzApplication.class, args);
    }

}
