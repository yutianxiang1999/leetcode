package com.leetcode.part487;

public class Solution {
    // 给定一个二进制数组 nums ，如果最多可以翻转一个 0 ，则返回数组中连续 1 的最大个数。

    /**
     * 例:
     * 输入：nums = [1,0,1,1,0]
     * 输出：4
     * 解释：翻转第一个 0 可以得到最长的连续 1。
     * 当翻转以后，最大连续 1 的个数为 4。
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test1 = {1, 0, 1, 1, 0};
        int[] test2 = {1, 0, 1, 1, 0, 1};
        int res1 = solution.findMaxConsecutiveOnes(test1);
        int res2 = solution.findMaxConsecutiveOnes(test2);
        System.out.println(res1);
        System.out.println(res2);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        // 双指针
        int left = 0, right = left, res = 0;

        while (right < nums.length) {
            // 开启一轮右指针遍历
            // 记录遍历结束前的上一个0索引
            int zeroIndex = -1;

            // 开始遍历
            while (right < nums.length) {
                // 如果出现0
                if (nums[right] == 0) {
                    // 第一次出现
                    if (zeroIndex == -1) zeroIndex = right;
                        // 结束遍历
                    else break;
                }

                // 当0的次数小于等于1，或当前数字为1时
                // 右指针右移
                right++;
            }
            res = Math.max(res, right - left);
            if(zeroIndex != -1) left = right = zeroIndex + 1;
        }

        return res;
    }
}
