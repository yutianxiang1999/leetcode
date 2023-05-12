package com.leetcode.part266;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String test1 = "code";
        String test2 = "aab";
        String test3 = "carerac";

        boolean res1 = solution.canPermutePalindrome(test1);
        boolean res2 = solution.canPermutePalindrome(test2);
        boolean res3 = solution.canPermutePalindrome(test3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    /**
     * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
     * 示例 1：
     * 输入: "code"
     * 输出: false
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int findOddNums = 0;


        for (int i = 0; i < s.length(); i++) {
            Integer v = hashMap.get(s.charAt(i));
            if (v == null) v = 1;
            else v++;
            hashMap.put(s.charAt(i), v);
        }

        System.out.println(hashMap);
        for (int value : hashMap.values()) {
            if (value % 2 != 0) {
                findOddNums++;
                if (findOddNums > 1) {
                    break;
                }
            }
        }
        return findOddNums <= 1;
    }
}
