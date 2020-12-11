package com.xiahaolei.algorithm.design.decker;

/**
 * 摩卡.
 *
 * @author jialin.li
 * @date 2019-12-26 23:05
 */
public class Mocha extends Decorator {
    public Mocha(Beverage coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "加摩卡";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 2.5d;
    }
}