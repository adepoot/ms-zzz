package com.antondepoot.zzz.infra.database;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan(basePackages = "com.antondepoot.zzz.infra.database")
@DataJpaTest
@ActiveProfiles("it")
public @interface DatabaseIntegrationTest {
}
