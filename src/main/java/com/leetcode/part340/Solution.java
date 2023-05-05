package com.leetcode.part340;

import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String test1_1 = "eceba";
        int test1_2 = 2;
        String test2_1 = "aa";
        int test2_2 = 1;

        int res1 = solution.lengthOfLongestSubstringKDistinct(test1_1, test1_2);
        int res2 = solution.lengthOfLongestSubstringKDistinct(test2_1, test2_2);
        System.out.println(res1);
        System.out.println(res2);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) return 0;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        //
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 1;

        while (right < n) {

            // add new character and move right pointer
            hashmap.put(s.charAt(right), right++);


            // slidewindow contains 3 characters
            if (hashmap.size() == k + 1) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}
