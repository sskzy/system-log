package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : songtc
 * @since : 2023/09/22 11:00
 */
@Getter
@Setter
public final class ReturnData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public ReturnData() {
    }

    public ReturnData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ReturnData<T> success(T data) {
        return restResult(200, "success", data);
    }

    public static <T> ReturnData<T> success(String msg, T data) {
        return restResult(200, msg, data);
    }

    public static <T> ReturnData<T> failed(T data) {
        return restResult(500, "failed", data);
    }

    public static <T> ReturnData<T> failed(String msg, T data) {
        return restResult(500, msg, data);
    }

    public static <T> ReturnData<T> restResult(int code, String msg, T data) {
        return new ReturnData<T>(code, msg, data);
    }
}
