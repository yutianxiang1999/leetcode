package com.leetcode.part1120;

import com.leetcode.Utils.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumAverageSubtree(new TreeNode(5,
                new TreeNode(6),
                new TreeNode(1))));
    }
    double maxValue = 0;
    /**
     * 给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
     * 子树是树中的任意节点和它的所有后代构成的集合。
     * 树的平均值是树中节点值的总和除以节点数。
     * 示例：
     * 输入：[5,6,1]
     * 输出：6.00000
     * 解释：
     * 以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
     * 以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
     * 以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
     * 所以答案取最大值 6。
     */
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return maxValue;
    }

    public int[] dfs(TreeNode root) {
        int curSum = root.val, count = 1;

        if(root.left != null) {
            int[] leftRes = dfs(root.left);
            curSum += leftRes[0];
            count += leftRes[1];
        }
        if(root.right != null) {
            int[] rightRes = dfs(root.right);
            curSum += rightRes[0];
            count += rightRes[1];
        }

        maxValue = Math.max(maxValue, (double) curSum / count);
        return new int[] {curSum, count};
    }
}
