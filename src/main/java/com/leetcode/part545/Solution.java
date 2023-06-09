package com.leetcode.part545;

import com.leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // System.out.println(solution.boundaryOfBinaryTree(new TreeNode(1, null,
        //         new TreeNode(2, new TreeNode(3), new TreeNode(4)))));
        // System.out.println(solution.boundaryOfBinaryTree(new TreeNode(
        //         1,
        //         new TreeNode(
        //                 2,
        //                 new TreeNode(4),
        //                 new TreeNode(
        //                         5,
        //                         new TreeNode(7),
        //                         new TreeNode(8)
        //                 )
        //         ),
        //         new TreeNode(
        //                 3,
        //                 new TreeNode(
        //                         6,
        //                         new TreeNode(9),
        //                         new TreeNode(10)
        //                 ),
        //                 null
        //         )
        // )));
        // System.out.println(solution.boundaryOfBinaryTree(new TreeNode(1)));
        System.out.println(solution.boundaryOfBinaryTree(new TreeNode(
                37,
                new TreeNode(
                        -34,
                        null,
                        new TreeNode(-100)
                ),
                new TreeNode(
                        -48,
                        new TreeNode(-100),
                        new TreeNode(
                                48,
                                new TreeNode(
                                        -54,
                                        new TreeNode(-71),
                                        new TreeNode(
                                                -22,
                                                null,
                                                new TreeNode(8)
                                        )
                                ),
                                null
                        )
                )
        )));
    }

    // 二叉树的 边界 是由 根节点 、左边界 、按从左到右顺序的 叶节点 和 逆序的右边界 ，按顺序依次连接组成。
    // 左边界 是满足下述定义的节点集合：
    // 根节点的左子节点在左边界中。如果根节点不含左子节点，那么左边界就为 空 。
    // 如果一个节点在左边界中，并且该节点有左子节点，那么它的左子节点也在左边界中。
    // 如果一个节点在左边界中，并且该节点 不含 左子节点，那么它的右子节点就在左边界中。
    // 最左侧的叶节点 不在 左边界中。
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<Integer> leftBoundary = new ArrayList<>();
        List<Integer> leafNode = new ArrayList<>();
        Stack<Integer> rightBoundary = new Stack<>();
        res.add(root.val);
        if (root.left != null) {
            searchLeftBoundary(root.left, leftBoundary);
            res.addAll(leftBoundary);
        }

        if(root.left != null || root.right != null) {
            searchLeafNode(root, leafNode);
            res.addAll(leafNode);
        }

        if (root.right != null)
            searchRightBoundary(root.right, rightBoundary);
        while (!rightBoundary.isEmpty()) {
            res.add(rightBoundary.pop());
        }

        return res;
    }

    // 寻找左边界
    public void searchLeftBoundary(TreeNode node, List<Integer> leftBoundary) {
        // 如果为叶子结点则无需加入
        if (node.left != null || node.right != null) {
            leftBoundary.add(node.val);
        }
        // 如果当前节点存在左子结点，则将左子结点加入左边界
        if (node.left != null) {
            searchLeftBoundary(node.left, leftBoundary);
        }
        // 如果不存在左子结点，存在右子节点，将右子节点加入左边界
        if (node.left == null && node.right != null) {
            searchLeftBoundary(node.right, leftBoundary);
        }
    }

    // 寻找从左到右的叶子结点
    public void searchLeafNode(TreeNode node, List<Integer> leafNode) {
        if (node.left == null && node.right == null)
            leafNode.add(node.val);
        if (node.left != null)
            searchLeafNode(node.left, leafNode);
        if (node.right != null)
            searchLeafNode(node.right, leafNode);
    }

    // 寻找右边界
    public void searchRightBoundary(TreeNode node, Stack<Integer> rightBoundary) {
        // 如果为叶子结点则无需加入
        if (node.left != null || node.right != null) {
            rightBoundary.push(node.val);
        }
        // 如果当前节点存在右子结点，则将右子结点加入右边界
        if (node.right != null) {
            searchRightBoundary(node.right, rightBoundary);
        } else {
            // 如果不存在右子结点，存在左子节点，将左子节点加入右边界
            if(node.left != null) {
                searchRightBoundary(node.left, rightBoundary);
            }
        }
    }
}
