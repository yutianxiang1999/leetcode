package com.leetcode.part253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
                {0, 30},
                {5, 10},
                {15, 20}
        };
        int[][] test2 = {
                {7, 10},
                {2, 4}
        };
        int res1 = solution.minMeetingRooms(test1);
        System.out.println(res1);
    }

    /**
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
     * 示例 1：
     * 输入：intervals = [[0,30],[5,10],[15,20]]
     * 输出：2
     * 示例 2：
     * 输入：intervals = [[7,10],[2,4]]
     * 输出：1
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 存储会议结束时间的最小堆
        PriorityQueue<Integer> allocator =
                new PriorityQueue<>(
                        intervals.length,
                        Comparator.comparingInt(a -> a));

        // 按会议开始时间升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 添加第一个会议的结束时间到最小堆
        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // 如果当前会议的开始时间大于最小堆中的结束时间，则说明该会议室已被释放，移除该结束时间
            if(intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            // 将当前会议的结束时间添加进最小堆
            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
