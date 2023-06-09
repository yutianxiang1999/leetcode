package com.leetcode.part314;

import com.leetcode.Utils.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // System.out.println(solution.verticalOrder(new TreeNode(
        //         3,
        //         new TreeNode(
        //                 9,
        //                 new TreeNode(4),
        //                 new TreeNode(
        //                         0,
        //                         null,
        //                         new TreeNode(2)
        //                 )
        //         ),
        //         new TreeNode(
        //                 8,
        //                 new TreeNode(
        //                         1,
        //                         new TreeNode(5),
        //                         null
        //                 ),
        //                 new TreeNode(7)
        //         )
        // )));
        System.out.println(solution.verticalOrder(null));
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    /**
     * 给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
     * <p>
     * 如果两个结点在同一行和列，那么顺序则为 从左到右。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[9],[3,15],[20],[7]]
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        bfs(root);
        TreeSet<Integer> sortKeys = new TreeSet<>(map.keySet());

        for (Integer key : sortKeys) {
            res.add(map.get(key));
        }
        return res;
    }

    public void bfs(TreeNode node) {
        Queue<Object[]> treeNodeList = new LinkedList<>();
        treeNodeList.add(new Object[]{0, node});

        while (treeNodeList.size() > 0) {
            Object[] obj = treeNodeList.poll();
            int curIndex = (int) obj[0];
            TreeNode curNode = (TreeNode) obj[1];
            if (!map.containsKey(curIndex)) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(curNode.val);
                map.put(curIndex, tmp);
            } else {
                map.get(curIndex).add(curNode.val);
            }
            if (curNode.left != null) {
                treeNodeList.add(new Object[]{curIndex - 1, curNode.left});
            }
            if (curNode.right != null) {
                treeNodeList.add(new Object[]{curIndex + 1, curNode.right});
            }
        }
    }
}
