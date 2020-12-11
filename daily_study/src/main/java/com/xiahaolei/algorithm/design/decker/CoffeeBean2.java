package com.xiahaolei.algorithm.design.decker;

/**
 * 咖啡豆2
 *
 * @author jialin.li
 * @date 2019-12-26 23:00
 */
public class CoffeeBean2 implements Beverage{
    @Override
    public String getDescription() {
        return "第一种咖啡豆";
    }

    @Override
    public double getPrice() {
        return 12.5d;
    }
}