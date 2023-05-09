package com.leetcode.part1100;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        HashMap<String, Object> test1 = new HashMap<>();
        test1.put("S", "havefunonleetcode");
        test1.put("K", 5);

        int res1 = solution.numKLenSubstrNoRepeats((String) test1.get("S"), (int) test1.get("K"));
        System.out.println(res1);
    }
    // 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。

    /**
     * 输入：S = "havefunonleetcode", K = 5
     * 输出：6
     * 解释：
     * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
     */
    public int numKLenSubstrNoRepeats(String s, int k) {
        int num = 0;
        // 左右指针
        int left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        // 左指针遍历，当剩余步数小于K时终止
        while (left <= s.length() - k) {
            // 右指针
            int right = left + 1;
            // 记录字符是否出现过
            hashMap.put(s.charAt(left), 1);
            // 开始一轮右指针遍历
            while (right - left < k && right < s.length()) {
                // 如果map中已存在，则直接中断
                if (hashMap.containsKey(s.charAt(right))) break;
                else hashMap.put(s.charAt(right), 1);
                // 右指针右移
                right++;
            }
            // 判断是否满足k的长度
            if (right - left == k) num++;
            // 左指针右移
            left++;
            // 清除map
            hashMap.clear();
        }
        return num;
    }
}
