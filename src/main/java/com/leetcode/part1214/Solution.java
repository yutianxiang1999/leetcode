package com.leetcode.part1214;

import com.leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().twoSumBSTs(
                new TreeNode(
                        0,
                        new TreeNode(-10),
                        new TreeNode(10)
                ),
                new TreeNode(
                        5,
                        new TreeNode(
                                1,
                                new TreeNode(0),
                                new TreeNode(2)
                        ),
                        new TreeNode(7)
                ),
                18
        ));
    }

    /**
     * 给出两棵二叉搜索树的根节点 root1 和 root2 ，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
     * 如果可以找到返回 True，否则返回 False。
     * 示例 1：
     * 输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
     * 输出：true
     * 解释：2 加 3 和为 5 。
     * 示例 2：
     * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
     * 输出：false
     */
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> seq1 = new ArrayList<>(), seq2 = new ArrayList<>();
        collect(root1, seq1);
        collect(root2, seq2);

        int i1 = 0, i2 = seq2.size() - 1;
        while (i1 < seq1.size() && i2 > 0) {
            if (seq1.get(i1) + seq2.get(i2) == target)
                return true;
            if (seq1.get(i1) + seq2.get(i2) > target)
                i2--;
            if (seq1.get(i1) + seq2.get(i2) < target)
                i1++;
        }
        return false;
    }

    public void collect(TreeNode root, List<Integer> seq) {
        if (root.left != null)
            collect(root.left, seq);
        seq.add(root.val);
        if (root.right != null)
            collect(root.right, seq);
    }
}
