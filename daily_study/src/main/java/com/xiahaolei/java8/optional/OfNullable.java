package com.xiahaolei.java8.optional;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OfNullable {
    @Test
    public void testOptional() {
        //1.optional通过of的工厂创建对象，然后由get获取optional所对应的值
        Optional<String> name = Optional.of("wangwei");
        String str = name.get();
        System.out.println(str);
        //2. 使用optional.of() 如果方法里面传入的参数为null的话会报空指针异常
//        Optional<String> nullString = Optional.of(null);
//        System.out.println(nullString);
    }

    @Test
    public void testOfNullable() {
        Optional<String> string = Optional.ofNullable(null);
        //打印的是一个空的optional  如果使用空的optional.get的时候会报空指针异常
        System.out.println(string);//Optional.empty
        // String s = string.get();//java.util.NoSuchElementException: No value present
        //System.out.println(s);
    }

    @Test
    public void testIsPresent() {
        Optional<String> string = Optional.ofNullable("xiahaolei");
        if (string.isPresent()) {
            System.out.println(string.get());
        }
    }

    public static void main(String[] args) {
        /* of */
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("YanWei");
        //传入参数为null，抛出NullPointerException.
        //Optional<String> someNull = Optional.of(null);

        /*opNullable*/
        Optional empty = Optional.ofNullable(null);

        /*isPresent*/
        if (name.isPresent()) {
            System.out.println(name.get());//输出YanWei
        }

        /*get*/
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }

        /*ifPresent*/
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });

        /*orElse*/
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));

        /*orElseGet*/
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(String::new));

        /*orElseThrow*/
        try {
            empty.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable ex) {
            System.out.println("error:" + ex.getMessage());
        }

        /*map*/
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        /*flatMap*/
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.get());

        /*filter*/
        List<String> names = Arrays.asList("YanWei", "YanTian");
        for (String s : names) {
            Optional<String> nameLenLessThan7 = Optional.of(s).filter((value) -> value.length() < 7);
            System.out.println(nameLenLessThan7.orElse("The name is more than 6 characters"));
        }
    }

}
