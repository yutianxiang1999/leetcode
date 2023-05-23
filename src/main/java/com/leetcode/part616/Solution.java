package com.leetcode.part616;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test1_1 = "aaabbcc";
        String[] test1_2 = {
                "aaa",
                "aab",
                "bc"
        };

        String res1 = solution.boldWords(test1_1, test1_2);
        System.out.println(res1);
    }
    /**
     * 给你一个字符串 s 和一个字符串列表 words ，你需要将在字符串列表中出现过的 s 的子串添加加粗闭合标签 <b> 和 </b> 。
     * 如果两个子串有重叠部分，你需要把它们一起用一对闭合标签包围起来。同理，如果两个子字符串连续被加粗，那么你也需要把它们合起来用一对加粗标签包围。
     * 返回添加加粗标签后的字符串 s 。
     * 示例 1：
     * 输入： s = "abcxyz123", words = ["abc","123"]
     * 输出："<b>abc</b>xyz<b>123</b>"
     * 示例 2：
     * 输入：s = "aaabbcc", words = ["aaa","aab","bc"]
     * 输出："<b>aaabbc</b>c
     */
    public String boldWords(String S, String[] words) {
        int N = S.length();
        // 映射字符串索引的数组
        boolean[] mask = new boolean[N];
        // 遍历数组
        for (int i = 0; i < N; ++i)
            // 遍历字符串列表
            for (String word: words) search: {
                // 遍历字符串
                for (int k = 0; k < word.length(); ++k)
                    if (k+i >= S.length() || S.charAt(k+i) != word.charAt(k))
                        break search;

                for (int j = i; j < i+word.length(); ++j)
                    mask[j] = true;
            }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            if (mask[i] && (i == 0 || !mask[i-1]))
                ans.append("<b>");
            ans.append(S.charAt(i));
            if (mask[i] && (i == N-1 || !mask[i+1]))
                ans.append("</b>");
        }
        return ans.toString();
    }
}
