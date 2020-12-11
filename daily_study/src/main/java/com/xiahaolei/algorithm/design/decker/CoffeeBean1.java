package com.xiahaolei.algorithm.design.decker;

/**
 * 咖啡豆1
 *
 * @author jialin.li
 * @date 2019-12-26 22:59
 */
public class CoffeeBean1 implements Beverage {

    @Override
    public String getDescription() {
        return "第一种咖啡豆";
    }

    @Override
    public double getPrice() {
        return 10d;
    }
}