package com.leetcode.part1133;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {99};

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
        // 能否使用两个变量代替map
        // int max = -1, preMax = -1;

        /* 解题思路:
          1. 遍历nums
          2. 比较当前Num和
          X 行不通
         */
        // 能否使用数组来代替map
        /* 解题思路:
        1 <= A.length <= 2000
        0 <= A[i] <= 1000
          1. 将nums数组中的每个值作为index，出现次数作为value存入数组中
          2. 因为值为index，所以数组中倒序访问就是从大到小访问
          3. 倒序遍历数组，如果该值==1则返回该值
         */

        int[] map = new int[1001];

        for (int num : nums) {
            map[num]++;
        }

        for(int i = map.length - 1; i >= 0; i--) {
            if (map[i] == 1) return i;
        }

        return -1;
    }
}
