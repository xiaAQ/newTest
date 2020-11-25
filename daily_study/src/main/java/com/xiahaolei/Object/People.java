package com.xiahaolei.Object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People implements Cloneable{
    private int age;
    private String name;
    private String hobby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name) &&
                Objects.equals(hobby, people.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, hobby);
    }
}
