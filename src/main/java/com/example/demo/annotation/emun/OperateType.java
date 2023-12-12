package com.example.demo.annotation.emun;

import lombok.Getter;

/**
 * @author : songtc
 * @since : 2023/09/22 10:31
 */
@Getter
public enum OperateType {

    DEFAULT(0, "默认"),
    INSERT(1, "增加"),
    DELETE(2, "删除"),
    UPDATE(3, "更新"),
    SELECT(4, "查询");

    private final Integer code;
    private final String value;

    OperateType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
