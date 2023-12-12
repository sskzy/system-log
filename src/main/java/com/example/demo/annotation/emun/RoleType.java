package com.example.demo.annotation.emun;

import lombok.Getter;

/**
 * @author : songtc
 * @since : 2023/09/22 10:32
 */
@Getter
public enum RoleType {

    DEFAULT(0, "默认"),
    ADMIN(1, "管理员");

    private final Integer code;
    private final String value;

    RoleType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
