package com.example.demo.annotation;

import com.example.demo.annotation.emun.OperateType;
import com.example.demo.annotation.emun.RoleType;

import java.lang.annotation.*;

/**
 * @author : songtc
 * @since : 2023/09/22 10:23
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {
    /** 日志名称 */
    String value() default "";
    /** 日志备注 */
    String remark() default "";
    /** 日志操作类型 */
    OperateType operateType() default OperateType.DEFAULT;
    /** 日志操作角色类型 */
    RoleType roleType() default RoleType.DEFAULT;
}
