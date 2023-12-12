package com.example.demo.service.impl;

import com.example.demo.domain.Msg;
import com.example.demo.service.MsgService;
import org.springframework.stereotype.Service;

/**
 * @Author: songtc
 * @Date: 2023/09/22 上午 10:47
 * @Description:
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Override
    public Msg select(String msg) {
        return new Msg(msg);
    }
}
