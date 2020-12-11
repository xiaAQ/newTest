package com.xiahaolei.java8.stream.sorted;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Format;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private Integer age;
    private String sex;
    @Format(formats = "yyyy-MM-dd")
    private Date birthday;
}
