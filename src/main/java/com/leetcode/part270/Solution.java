package com.leetcode.part270;

import com.leetcode.Utils.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.closestValue(new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(5)
        ), 3.714286));
    }

    /**
     * 给你二叉搜索树的根节点 root 和一个目标值 target ，请在该二叉搜索树中找到最接近目标值 target 的数值。如果有多个答案，返回最小的那个。
     * 示例 1：
     * 输入：root = [4,2,5,1,3], target = 3.714286
     * 输出：4
     * 示例 2：
     * 输入：root = [1], target = 4.428571
     * 输出：1
     */
    int res = 0;

    public int closestValue(TreeNode root, double target) {
        res = root.val;
        dfs(root, target);
        return res;
    }


    public void dfs(TreeNode node, double target) {
        if(Math.abs(node.val - target) == Math.abs(res - target))
            res = Math.min(res, node.val);
        if (Math.abs(node.val - target) < Math.abs(res - target))
            res = node.val;

        if (target > node.val && node.right != null) {
            dfs(node.right, target);
        } else if (target < node.val && node.left != null) {
            dfs(node.left, target);
        }
    }
}
