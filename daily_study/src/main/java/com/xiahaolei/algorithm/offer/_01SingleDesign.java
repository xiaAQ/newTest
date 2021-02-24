package com.xiahaolei.algorithm.offer;


/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/2/24 16:53]
 * @Desc:
 */
public class _01SingleDesign {

    private static class SingletonHodler {
        private static _01SingleDesign ourInstance = new _01SingleDesign();
    }

    public static _01SingleDesign getInstance() {
        return SingletonHodler.ourInstance;
    }

    private _01SingleDesign() {
    }

}

class my{
    public static void main(String[] args) {
        _01SingleDesign instance = _01SingleDesign.getInstance();
        System.out.println(instance);
    }
}
