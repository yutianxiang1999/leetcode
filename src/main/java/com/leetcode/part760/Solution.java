package com.leetcode.part760;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test1_1 = {12, 28, 46, 32, 50, 12};
        int[] test1_2 = {50, 12, 32, 46, 12, 28};

        int[] res1 = solution.anagramMappings(test1_1, test1_2);
        System.out.println(Arrays.toString(res1));
    }

    /**
     * 给定两个列表 Aand B，并且 B 是 A 的变位（即 B 是由 A 中的元素随机排列后组成的新列表）。
     * 我们希望找出一个从 A 到 B 的索引映射 P 。一个映射 P[i] = j 指的是列表 A 中的第 i 个元素出现于列表 B 中的第 j 个元素上。
     * 列表 A 和 B 可能出现重复元素。如果有多于一种答案，输出任意一种。
     * 例如，给定
     * A = [12, 28, 46, 32, 50]
     * B = [50, 12, 32, 46, 28]
     * 需要返回
     * [1, 4, 3, 2, 0]
     */
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i], i);
        }

        int t = 0;
        for (int i : nums1) {
            res[t++] = hashMap.get(i);
        }

        return res;
    }
}
