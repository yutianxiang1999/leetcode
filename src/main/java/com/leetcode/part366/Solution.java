package com.leetcode.part366;

import com.leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findLeaves(new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3)
        )));
    }

    /**
     * 给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
     * 依次从左到右，每次收集并删除所有的叶子节点
     * 重复如上过程直到整棵树为空
     * 示例:
     * 输入: [1,2,3,4,5]
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 输出: [[4,5,3],[2],[1]]
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        while (root.left != null || root.right != null) {
            List<Integer> curList = new ArrayList<>();
            dfs(root, curList);
            res.add(curList);
        }

        List<Integer> curList = new ArrayList<>();
        curList.add(root.val);
        res.add(curList);
        return res;
    }

    public TreeNode dfs(TreeNode node, List<Integer> curList) {
        if (node.left == null && node.right == null) {
            curList.add(node.val);
            return null;
        }
        if (node.left != null) {
            node.left = dfs(node.left, curList);
        }
        if (node.right != null) {
            node.right = dfs(node.right, curList);
        }
        return new TreeNode(node.val, node.left, node.right);
    }
}
