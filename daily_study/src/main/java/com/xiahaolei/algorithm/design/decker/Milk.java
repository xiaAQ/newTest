package com.xiahaolei.algorithm.design.decker;

/**
 * 牛奶.
 *
 * @author jialin.li
 * @date 2019-12-26 23:03
 */
public class Milk extends Decorator {
    public Milk(Beverage coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "加牛奶";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 1.5d;
    }
}