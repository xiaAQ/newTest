package com.xiahaolei.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/2/24 17:04
 * @Desc:题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列 都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一 个整数，判断数组中是否含有该整数。
 */
public class _02SearchValue {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        boolean value = findValue(arr, 10);
        System.out.println(value);
    }

    //解法1. 遍历
    public static boolean findValue(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        //行
        int row = 0;
        //列
        int column = array[0].length - 1;
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    //解法2：二分法
    public static boolean division(int[][] array, int target) {
        return true;
    }

}
