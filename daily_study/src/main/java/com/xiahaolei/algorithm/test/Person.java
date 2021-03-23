package com.xiahaolei.algorithm.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/3/8 17:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
}
