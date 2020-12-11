package com.xiahaolei.algorithm.design.decker;

/**
 * 测试类.
 *
 * @author jialin.li
 * @date 2019-12-26 23:09
 */
public class Main {
    public static void main(String[] args) {
        CoffeeBean1 coffee1 = new CoffeeBean1();
        CoffeeBean2 coffee2 = new CoffeeBean2();

        // 加蜂蜜
        Beverage honey = new Honey(coffee1);
        // 加摩卡
        Beverage mocha = new Mocha(honey);
        System.out.println(mocha.getDescription());
        System.out.println(mocha.getPrice());

        // 加牛奶
        Milk milk = new Milk(coffee2);
        System.out.println(milk.getDescription());
        System.out.println(milk.getPrice());
    }
}