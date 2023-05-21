package com.leetcode.part311;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] test1_1 = {
                {1,-5}
        };
        int[][] test1_2 = {
                {12},
                {-1}
        };
        int[][] res1 = solution.multiply(test1_1, test1_2);
        System.out.println(Arrays.deepToString(res1));
    }

    /**
     * 给定两个 稀疏矩阵 ：大小为 m x k 的稀疏矩阵 mat1 和大小为 k x n 的稀疏矩阵 mat2 ，返回 mat1 x mat2 的结果。你可以假设乘法总是可能的。
     * 示例 1：
     * 输入：mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
     * 输出：[[7,0,0],[-7,0,3]]
     *  示例 2:
     * 输入：mat1 = [[0]], mat2 = [[0]]
     * 输出：[[0]]
     * 矩阵乘法：
     * res[i][j] = mat1[i][0] * mat2[0][j] + mat1[i][1] * mat2[1][j] + ...
     * res[1][0] = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0]
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int c = 0; c < k; c++) {
                if (mat1[i][c] == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    res[i][j] += mat1[i][c] * mat2[c][j];
                }
            }
        }
        return res;
    }
}
