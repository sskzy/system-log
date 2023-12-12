package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author : songtc
 * @since : 2023/12/12 16:20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /** 注解备注 */
    String remark() default "";
}
