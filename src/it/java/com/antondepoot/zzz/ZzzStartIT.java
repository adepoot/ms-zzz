package com.antondepoot.zzz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("it")
public class ZzzStartIT {

    @Autowired
    ApplicationContext context;

    @Test
    void application_starts() {
        assertThat(context).isNotNull();
    }
}
