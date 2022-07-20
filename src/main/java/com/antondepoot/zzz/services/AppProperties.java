package com.antondepoot.zzz.services;

import com.antondepoot.zzz.domain.entities.Season;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ms-zzz.app")
public class AppProperties {

    private Season season;
    private String lzvcupBaseUrl;

}
