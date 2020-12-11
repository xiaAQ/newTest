package com.xiahaolei.algorithm.design.decker;

/**
 * 饮品.
 *
 * @author jialin.li
 * @date 2019-12-26 22:58
 */
public interface Beverage {
    /** 获取描述 */
    String getDescription();
    /** 获取金额 */
    double getPrice();
}