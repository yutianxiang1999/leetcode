package com.leetcode.part252;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
                {30, 45},
                {0, 10},
                {50, 60},
                {20, 25}
        };

        boolean b = solution.canAttendMeetings(test1);
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <= 1) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
