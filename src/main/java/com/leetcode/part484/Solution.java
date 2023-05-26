package com.leetcode.part484;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test1 = "I";
        String test2 = "DI";
        System.out.println(Arrays.toString(solution.findPermutation(test1)));
        System.out.println(Arrays.toString(solution.findPermutation(test2)));
    }
    /**
     * 由范围 [1,n] 内所有整数组成的 n 个整数的排列 perm 可以表示为长度为 n - 1 的字符串 s ，其中:
     * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
     * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 。
     * 给定一个字符串 s ，重构字典序上最小的排列 perm 并返回它。
     * 示例 1：
     * 输入： s = "I"
     * 输出： [1,2]
     * 解释： [1,2] 是唯一合法的可以生成秘密签名 "I" 的特定串，数字 1 和 2 构成递增关系。
     * 示例 2：
     * 输入： s = "DI"
     * 输出： [2,1,3]
     * 解释： [2,1,3] 和 [3,1,2] 可以生成秘密签名 "DI"，
     * 但是由于我们要找字典序最小的排列，因此你需要输出 [2,1,3]。
     * 提示：
     * 1 <= s.length <= 105
     * s[i] 只会包含字符 'D' 和 'I'。
     */
    public int[] findPermutation(String s) {
        int[] intArr = new int[s.length() + 1];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i + 1;
        }
        int left = 0;
        while (left < s.length()) {
            if(s.charAt(left) == 'I') {
                left++;
            } else {
                int right = left;
                while (right < s.length() && s.charAt(right) == 'D') {
                    right++;
                }

                exchange(intArr, left, right);

                left = right + 1;
            }
        }

        return intArr;
    }

    public void exchange(int[] arr, int start, int end) {
        while (start <= end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
