package com.leetcode.part531;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] picture = {
                {'W', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'W'}
        };
        int res1 = solution.findLonelyPixel(picture);
        System.out.println(res1);
    }

    int[] row = new int[500];
    int[] col = new int[500];

    /**
     * 给你一个大小为 m x n 的图像 picture ，图像由黑白像素组成，'B' 表示黑色像素，'W' 表示白色像素，请你统计并返回图像中 黑色 孤独像素的数量。
     * 黑色孤独像素 的定义为：如果黑色像素 'B' 所在的同一行和同一列不存在其他黑色像素，那么这个黑色像素就是黑色孤独像素。
     * 示例 1：
     * 输入：picture = [["W","W","B"],["W","B","W"],["B","W","W"]]
     * 输出：3
     * 解释：全部三个 'B' 都是黑色的孤独像素
     */
    public int findLonelyPixel(char[][] picture) {
        int w = picture.length;
        int h = picture[0].length;

        // 记录每一行和每一列中出现了多少次黑像素
        for(int i = 0; i < w; ++i) {
            for(int j = 0; j < h; ++j) {
                if(picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int res = 0;
        // 遍历二维数组，如果根据row、col判断是否只有黑像素
        for(int i = 0; i < w; ++i) {
            // 如果当前行的黑像素只有一个，遍历每一列
            if(row[i] == 1) {
                for(int j = 0; j < h; ++j) {
                    // 如果当前元素==B并且当前列的黑像素只有一个，res+1
                    if(picture[i][j] == 'B' && col[j] == 1) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
