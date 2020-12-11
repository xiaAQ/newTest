package com.xiahaolei.algorithm.design.decker;

/**
 * 蜂蜜.
 *
 * @author jialin.li
 * @date 2019-12-26 23:07
 */
public class Honey extends Decorator {
    public Honey(Beverage coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "加蜂蜜";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 4.5d;
    }
}
