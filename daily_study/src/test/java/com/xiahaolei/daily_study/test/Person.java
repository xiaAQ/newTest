package com.xiahaolei.daily_study.test;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/2/5 17:11
 */
@Data
@Builder
public class Person {
    private String name;
    private Integer age;
}
