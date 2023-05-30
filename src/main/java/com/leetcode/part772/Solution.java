package com.leetcode.part772;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test1 = "1+1";
        String test2 = "6-4/2";
        String test3 = "2*(5+5*2)/3+(6/2+8)";
        int result1 = solution.calculate(test1);
        int result2 = solution.calculate(test2);
        int result3 = solution.calculate(test3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    /**
     * 实现一个基本的计算器来计算简单的表达式字符串。
     * 表达式字符串只包含非负整数，算符 +、-、*、/ ，左括号 ( 和右括号 ) 。整数除法需要 向下截断 。
     * 你可以假定给定的表达式总是有效的。所有的中间结果的范围均满足 [-231, 231 - 1] 。
     * 注意：你不能使用任何将字符串作为表达式求值的内置函数，比如 eval() 。
     * 示例 1：
     * 输入：s = "1+1"
     * 输出：2
     * 示例 2：
     * 输入：s = "6-4/2"
     * 输出：4
     * 示例 3：
     * 输入：s = "2*(5+5*2)/3+(6/2+8)"
     * 输出：21
     */
    public int calculate(String s) {
        int[] result = dfs(s, 0);
        return result[0];
    }

    public int[] dfs(String s, int begin) {
        Deque<Integer> deque = new LinkedList<>();
        // result[0] 为计算结果，result[1] 为结束位置
        int[] result = new int[2];
        // presign 用于记录前一个符号，初始为 '+'
        char presign = '+';
        int n = s.length();
        // num 用于记录数字字符对应的数字
        int num = 0;
        for (int i = begin; i < n; i++) {
            char c = s.charAt(i);
            // 将数字字符转换为数字, 如: '38' 的计算为: 0 * 10 + 3 = 3, 3 * 10 + 8 = 38
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // 如果是左括号，那么就递归计算括号内的值
            if (c == '(') {
                int[] numNext = dfs(s, i + 1);
                // 递归计算后，获取括号内的值: numNext[0]，以及括号内的结束位置: numNext[1]
                num = numNext[0];
                // 将i移动到括号内的结束位置
                i = numNext[1];
            }
            // 对于末尾结束时 或 不是数字字符且字符不为'('时，对num进行处理
            if (i == n - 1 || !Character.isDigit(c) && c != '(') {
                switch (presign) {
                    case '+':
                        deque.push(num);
                        break;
                    case '-':
                        deque.push(-num);
                        break;
                    case '*':
                        deque.push(deque.pop() * num);
                        break;
                    default:
                        deque.push(deque.pop() / num);
                        break;
                }
                // 如果结束是右括号，那么就记录位置结束循环。
                if (c == ')') {
                    result[1] = i;
                    break;
                }
                presign = c;
                num = 0;
            }

        }
        while (!deque.isEmpty()) {
            result[0] += deque.pop();
        }
        return result;
    }
}
