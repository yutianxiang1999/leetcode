package com.leetcode.part1198;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
                {1,2,3,4,5},
                {2,4,5,8,10},
                {3,5,7,9,11},
                {1,3,5,7,9},
        };
        int res1 = solution.smallestCommonElement(test1);
        System.out.println(res1);
    }

    /**
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 500
     * 1 <= mat[i][j] <= 104
     * mat[i] 已按严格递增顺序排列。
     */
    public int smallestCommonElement(int[][] mat) {
        // 存储每个元素出现的次数
        int[] count = new int[10001];
        // 存储二维数组的行数和列数
        int n = mat.length, m = mat[0].length;
        // 将每个元素的出现次数存储到count数组中
        for (int[] ints : mat) {
            for (int j = 0; j < m; ++j) {
                ++count[ints[j]];
            }
        }
        // 从小到大遍历count数组
        for (int k = 1; k < count.length; ++k) {
            // 判断当前元素的出现次数是否等于行数, 如果相等, 则说明该元素出现在了所有行中
            // 因为是从小到大遍历, 所以该元素就是最小的公共元素
            if (count[k] == n) {
                return k;
            }
        }
        return -1;
    }
}
