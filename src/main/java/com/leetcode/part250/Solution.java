package com.leetcode.part250;

import com.leetcode.Utils.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countUnivalSubtrees(new TreeNode(
                5,
                new TreeNode(
                        1,
                        new TreeNode(5),
                        new TreeNode(5)
                ),
                new TreeNode(
                        5,
                        null,
                        new TreeNode(5)
                )
        )));
    }

    /**
     * 给定一个二叉树，统计该二叉树数值相同的子树个数。
     * 同值子树是指该子树的所有节点都拥有相同的数值。
     * 示例：
     * 输入: root = [5,1,5,5,5,null,5]
     * 5
     * / \
     * 1   5
     * / \   \
     * 5   5   5
     * 输出: 4
     * 1. 该节点没有子结点 （基本情况）
     * 2. 该节点的所有子结点都为同值子树，且结点与其子结点值相同。
     */
    int count = 0;

    boolean is_uni(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }

        boolean is_unival = true;

        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
        }

        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }

        if (!is_unival) return false;
        count++;
        return true;
    }

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        is_uni(root);
        return count;
    }
}
