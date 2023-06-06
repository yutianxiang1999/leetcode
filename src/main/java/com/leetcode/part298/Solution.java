package com.leetcode.part298;

import com.leetcode.Utils.TreeNode;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // root = [1,null,3,2,4,null,null,null,5]
        TreeNode test1 = new TreeNode(
                1,
                null,
                new TreeNode(
                        3,
                        new TreeNode(2),
                        new TreeNode(
                                4,
                                null,
                                new TreeNode(5)
                        )
                )
        );

        System.out.println(solution.longestConsecutive(test1));
    }
    public int longestConsecutive(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int curSum, int maxSum) {
        int leftMaxSum = 1, rightMaxSum = 1;

        if(node.left != null) {
            int leftSum = node.val + 1 != node.left.val ? 1 : curSum + 1;
            leftMaxSum = dfs(
                    node.left,
                    leftSum,
                    Math.max(leftSum, maxSum)
            );
        }
        if(node.right != null) {
            int rightSum = node.val + 1 != node.right.val ? 1 : curSum + 1;
            rightMaxSum = dfs(
                    node.right,
                    rightSum,
                    Math.max(rightSum, maxSum)
            );
        }

        return Math.max(maxSum, Math.max(leftMaxSum, rightMaxSum));
    }
}
