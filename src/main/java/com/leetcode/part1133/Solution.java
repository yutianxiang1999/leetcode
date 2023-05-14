package com.leetcode.part1133;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {5,7,3,9,4,9,8,3,1};

        int res1 = solution.largestUniqueNumber(test1);
        System.out.println(res1);
    }

    /**
     * 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
     * 如果不存在这个只出现一次的整数，则返回 -1。
     * 示例 1：
     * 输入：[5,7,3,9,4,9,8,3,1]
     * 输出：8
     * 解释：
     * 数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
     * 示例 2：
     * 输入：[9,9,8,8]
     * 输出：-1
     * 解释：
     * 数组中不存在仅出现一次的整数。
     */
    public int largestUniqueNumber(int[] nums) {
        int res = -1;

        // map存储出现整数和其出现次数
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if(!hashMap.containsKey(num)) hashMap.put(num, 1);
            else hashMap.put(num, hashMap.get(num)+1);
        }

        // 遍历map，value为1的记录最大值
        for (Integer k : hashMap.keySet()) if(hashMap.get(k) == 1) res = Math.max(k, res);

        return res;
    }
}
