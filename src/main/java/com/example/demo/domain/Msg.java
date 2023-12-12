package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : songtc
 * @since : 2023/09/22 11:16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg {

    /**
     * msg数据内容
     */
    private String value;
}
