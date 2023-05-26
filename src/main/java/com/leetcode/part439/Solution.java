package com.leetcode.part439;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test1 = "T?T?F:5:3";
        // String test2 = "F?1:T?4:5";
        String res1 = solution.parseTernary(test1);
        // String res2 = solution.parseTernary(test2);
        System.out.println(res1);
        // System.out.println(res2);
    }

    /**
     * 给定一个表示任意嵌套三元表达式的字符串 expression ，求值并返回其结果。
     * 你可以总是假设给定的表达式是有效的，并且只包含数字， '?' ，  ':' ，  'T' 和 'F' ，其中 'T' 为真， 'F' 为假。表达式中的所有数字都是 一位 数(即在 [0,9] 范围内)。
     * 条件表达式从右到左分组(大多数语言中都是这样)，表达式的结果总是为数字 'T' 或 'F' 。
     * 示例 1：
     * 输入： expression = "T?2:3"
     * 输出： "2"
     * 解释： 如果条件为真，结果为 2；否则，结果为 3。
     * 示例 2：
     * 输入： expression = "F?1:T?4:5"
     * 输出： "4"
     * 解释： 条件表达式自右向左结合。使用括号的话，相当于：
     * "(F ? 1 : (T ? 4 : 5))" --> "(F ? 1 : 4)" --> "4"
     * or "(F ? 1 : (T ? 4 : 5))" --> "(T ? 4 : 5)" --> "4"
     */
    public String parseTernary(String expression) {
        int n = expression.length();
        int checkLevel = 0;
        for (int j = 1; j < n; j++) {
            if (expression.charAt(j) == '?') checkLevel++;
            if (expression.charAt(j) == ':') checkLevel--;
            if (checkLevel == 0) return (expression.charAt(0) == 'T') ? parseTernary(expression.substring(2, j)) : parseTernary(expression.substring(j+1, n));
        }
        return expression;
    }
}
