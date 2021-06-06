package com.antondepoot.zzz.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties(prefix = "ms-zzz.web")
public class WebProperties {

    private List<String> allowedOrigins = new ArrayList<>();

}
