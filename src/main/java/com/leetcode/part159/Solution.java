package com.leetcode.part159;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //  给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
    public static void main(String[] args) {
        String test1 = "eceba";
        String test2 = "ccaabbb";

        Solution solution = new Solution();
        int res1 = solution.lengthOfLongestSubstringTwoDistinct(test1);
        int res2 = solution.lengthOfLongestSubstringTwoDistinct(test2);
        System.out.println(res1);
        System.out.println(res2);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, res_len = 0;
        // 通过左指针遍历字符串
        while (left < s.length()) {
            int right = left + 1;
            //    记录右指针遍历前的已包含字符
            List<Character> includeList = new ArrayList<Character>();
            includeList.add(s.charAt(left));
            char one = s.charAt(left);
            char two = ' ';
            //    记录本次右指针遍历的长度
            int curLen = 1;
            //    开启一轮右指针遍历
            while (right < s.length()) {
                //    如果当前字符不存在于已包含字符，添加
                //if (!includeList.contains(s.charAt(right))) includeList.add(s.charAt(right));
                if (two == ' ' && s.charAt(right) != one) two = s.charAt(right);

                if(s.charAt(right) == two || s.charAt(right) == one) {
                    //  右指针右移一位，长度加一
                    right++;
                    curLen++;
                } else {
                    break;
                }
            }
            //    判断最终返回长度和本次右指针移动长度大小并重新赋值
            res_len = Math.max(res_len, curLen);
            //    左指针右移
            left++;
        }

        return res_len;
    }

}
