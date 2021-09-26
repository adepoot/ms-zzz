package com.antondepoot.zzz.web;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@WebMvcTest
@ActiveProfiles("it")
public @interface RestIntegrationTest {

    @AliasFor(annotation = WebMvcTest.class, attribute = "controllers")
    Class<?>[] resources() default {};

}
