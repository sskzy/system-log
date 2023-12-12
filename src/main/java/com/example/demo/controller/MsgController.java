package com.example.demo.controller;

import com.example.demo.annotation.SysLog;
import com.example.demo.annotation.emun.OperateType;
import com.example.demo.annotation.emun.RoleType;
import com.example.demo.domain.Msg;
import com.example.demo.domain.ReturnData;
import com.example.demo.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author : songtc
 * @since : 2023/12/12 16:21
 */
@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    /**
     * http://localhost:8080/msg/select?msg=hello%20wrold
     */
    @GetMapping("/select")
    @SysLog(value = "保存数据", remark = "备注", roleType = RoleType.DEFAULT, operateType = OperateType.SELECT)
    public ReturnData<Msg> select(@PathParam("msg") String msg) {
        return ReturnData.success("success", msgService.select(msg));
    }
}
