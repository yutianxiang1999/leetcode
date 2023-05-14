package com.leetcode.part249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] test1 = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> res1 = solution.groupStrings(test1);
        System.out.println(res1);
    }

    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length <= 0) return new ArrayList<>();

        // 存储: 偏移量作为key，满足条件的字符串数组作为value
        HashMap<String, List<String>> map = new HashMap<>();

        // 遍历字符串数组
        for (String str : strings) {
            // 创建一个StringBuilder存储偏移量序列
            StringBuilder sb = new StringBuilder();
            // 遍历字符串中的每个字符
            for (char c : str.toCharArray()) {
                sb.append("#");
                int offset = (c - str.charAt(0) + 26) % 26;
                sb.append(offset);
            }
            // 将StringBuilder转为String
            String sb2str = sb.toString();

            // 如果map中还没有key为此偏移序列，则存入该key
            if (!map.containsKey(sb2str)) map.put(sb2str, new ArrayList<>());
            // 如果map中存在此key，将该字符串存入数组
            map.get(sb2str).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
