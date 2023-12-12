package com.example.demo.controller;

import com.example.demo.annotation.SysLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : songtc
 * @since : 2023/12/12 16:21
 */
@RestController
public class MsgController {

    /**
     * http://127.0.0.1:8080/login?msg=Hello World
     * 打印一下日志吧! (~^v^)~: SysLogBo(ip=172.25.96.1, classPath=com.example.demo.controller.MsgController,
     * method=login, params=["Hello World"], exec=0, remark=remark, logDateTime=2023-12-12 17:28:13)
     */
    @SysLog(remark = "remark")
    @RequestMapping("/login")
    public void login(String msg) {

    }
}
