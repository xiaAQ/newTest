package com.xiahaolei.algorithm.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _01_sum {
    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 空间复杂度 O(n)
     */
    public static void main(String[] args) {
        int[] su = {2, 7, 11, 15};
        int target = 9;
        int[] ints = sum(su, target);
        Arrays.stream(ints).forEach(e -> System.out.print(e));
    }

    /**
     * 时间复杂度为O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int ans = target - nums[i];
            if (map.containsKey(ans) && map.get(ans) != i) {
                res[0] = map.get(ans);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * 时间复杂度为 O(n~2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] sum(int[] nums, int target) {
        int[] resp = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    resp[0] = i;
                    resp[1] = j;
                }
            }
        }
        return resp;
    }
}
