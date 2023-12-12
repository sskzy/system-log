package com.example.demo.domain;

import com.example.demo.annotation.emun.OperateType;
import com.example.demo.annotation.emun.RoleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author : songtc
 * @since : 2023/12/12 16:24
 */
@Getter
@Setter
@ToString
public class SysLogBo {
    /**
     * 日志名称
     */
    private String value;
    /**
     * 访问url
     */
    private String url;
    /**
     * 日志操作类型
     */
    private int operateType;
    /**
     * 日志操作角色类型
     */
    private int roleType;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 类名
     */
    private String classPath;
    /**
     * 方法名
     */
    private String method;
    /**
     * 入参
     */
    private String params;
    /**
     * 执行时间
     */
    private Long exec;
    /**
     * 注解备注
     */
    private String remark;
    /**
     * 日志时间
     */
    private String logDateTime;
}
