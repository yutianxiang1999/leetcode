package com.leetcode.part1165;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String test1_1 = "abcdefghijklmnopqrstuvwxyz";
        String test1_2 = "cba";

        int res1 = solution.calculateTime(test1_1, test1_2);
        System.out.println("res1 : " + res1);
    }

    /**
     * 我们定制了一款特殊的键盘，所有的键都 排列在一行上 。
     * 给定一个长度为 26 的字符串 keyboard ，来表示键盘的布局(索引从 0 到 25 )。一开始，你的手指在索引 0 处。要输入一个字符，你必须把你的手指移动到所需字符的索引处。手指从索引 i 移动到索引 j 所需要的时间是 |i - j|。
     * 您需要输入一个字符串 word 。写一个函数来计算用一个手指输入需要多少时间。
     * 示例 1：
     * 输入：keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
     * 输出：4
     * 解释：从 0 号键移动到 2 号键来输出 'c'，又移动到 1 号键来输出 'b'，接着移动到 0 号键来输出 'a'。
     * 总用时 = 2 + 1 + 1 = 4.
     * 示例 2：
     * 输入：keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
     * 输出：73
     */



    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < keyboard.length(); i++) {
            keyMap.put(keyboard.charAt(i), i);
        }

        int res = 0, pre = 0;

        for (int i = 0; i < word.length(); i++) {
            int cur = keyMap.get(word.charAt(i));
            res += Math.abs(cur - pre);
            pre = cur;
        }
        return res;
    }
}
