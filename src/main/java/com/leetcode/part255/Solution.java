package com.leetcode.part255;

import com.leetcode.Utils.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
        System.out.println(solution.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
    }

    /**
     * 给定一个 无重复元素 的整数数组 preorder ， 如果它是以二叉搜索树的先序遍历排列 ，返回 true 。
     * 示例 1：
     * 输入: preorder = [5,2,1,3,6]
     * 输出: true
     * 示例 2：
     * 输入: preorder = [5,2,6,1,3]
     * 输出: false
     */
    public boolean verifyPreorder(int[] preorder) {
        int rootVal = -1;
        Stack<Integer> stack = new Stack<>();
        for (int v : preorder) {
            if (rootVal > v) {
                return false;
            }

            while (stack.size() > 0 && stack.peek() < v) {
                rootVal = stack.pop();
            }
            stack.push(v);
        }

        return true;
    }
}
