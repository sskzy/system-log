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
    @SysLog(remark = "remark")
    @RequestMapping("/login")
    public void login(String msg) {

    }
}
