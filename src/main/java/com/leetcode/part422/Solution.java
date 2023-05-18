package com.leetcode.part422;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> test1 = new ArrayList<>();
        test1.add("abc");
        test1.add("b");
        // test1.add("let");
        // test1.add("lep");
        boolean res1 = solution.validWordSquare(test1);
        System.out.println(res1);
    }

    /**
     * 给你一个单词序列，判断其是否形成了一个有效的单词方块。
     * 有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。
     * 注意：
     * 给定的单词数大于等于 1 且不超过 500。
     * 单词长度大于等于 1 且不超过 500。
     * 每个单词只包含小写英文字母 a-z。
     * 示例 1：
     * 输入：
     * [
     * "abcd",
     * "bnrt",
     * "crmy",
     * "dtye"
     * ]
     * 输出：
     * true
     * 解释：
     * 第 1 行和第 1 列都是 "abcd"。
     * 第 2 行和第 2 列都是 "bnrt"。
     * 第 3 行和第 3 列都是 "crmy"。
     * 第 4 行和第 4 列都是 "dtye"。
     * 因此，这是一个有效的单词方块。
     */
    public boolean validWordSquare(List<String> words) {

        for (int m = 0; m < words.size(); m++) {
            for (int n = 0; n < words.get(m).length(); n++) {
                if(words.size() <= n || words.get(n).length() <= m) {
                    return false;
                }
                if (words.get(m).charAt(n) != words.get(n).charAt(m)) {
                    return false;
                }
            }
        }

        return true;
    }
}
