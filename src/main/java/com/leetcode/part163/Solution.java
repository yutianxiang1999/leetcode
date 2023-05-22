package com.leetcode.part163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1_1 = {0, 1, 3, 50, 75};
        int test1_2 = 0, test1_3 = 99;
        List<List<Integer>> res1 = solution.findMissingRanges(test1_1, test1_2, test1_3);
        System.out.println(res1);

    }
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) {
            Integer[] arr = {lower, upper};
            res.add(Arrays.asList(arr));
            return res;
        }
        if(lower < nums[0]) {
            Integer[] arr = {lower, nums[0] - 1};
            res.add(Arrays.asList(arr));
        }
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] > 1) {
                Integer[] arr = {nums[i - 1] + 1, nums[i] - 1};
                res.add(Arrays.asList(arr));
            }
        }
        if(upper > nums[nums.length - 1]) {
            Integer[] arr = {nums[nums.length - 1] + 1, upper};
            res.add(Arrays.asList(arr));
        }
        return res;
    }
}
