package com.lzy.demo.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lgp on 2015/9/4.
 */
@Documented
@Retention(RUNTIME)
public @interface ContextLifeCycle {
    String value() default "App";
}
