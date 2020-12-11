package com.xiahaolei.algorithm.design.decker;

/**
 * 装饰器.
 *
 * @author jialin.li
 * @date 2019-12-26 23:02
 */
public class Decorator implements Beverage{

    protected Beverage coffee;

    @Override
    public String getDescription() {
        return "装饰器，由子类重写方法";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}