package com.leetcode.part272;

import com.leetcode.Utils.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.closestKValues(new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(5)
        ), 3.714286, 2));
    }

    Map<Double, List<Integer>> absMap = new HashMap<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();

        collectAbs(root, target);
        TreeSet<Double> keySort = new TreeSet<>(absMap.keySet());
        for (Double key : keySort) {
            res.addAll(absMap.get(key));
        }

        return res.subList(0, Math.min(k, res.size()));
    }

    public void collectAbs(TreeNode root, double target) {
        if(!absMap.containsKey(Math.abs(root.val - target))) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            absMap.put(Math.abs(root.val - target), tmp);
        } else {
            absMap.get(Math.abs(root.val - target)).add(root.val);
        }

        if(root.left != null)
            collectAbs(root.left, target);
        if(root.right != null)
            collectAbs(root.right, target);
    }
}
