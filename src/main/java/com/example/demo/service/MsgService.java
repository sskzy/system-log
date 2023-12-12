package com.example.demo.service;


import com.example.demo.domain.Msg;

/**
 * @Author: songtc
 * @Date: 2023/09/22 上午 10:46
 * @Description:
 */
public interface MsgService {

    /**
     * 获取消息数据
     *
     * @param msg 消息
     * @return 消息数据
     */
    Msg select(String msg);
}
