package com.leetcode.part369;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = solution.plusOne(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    /**
     * 给定一个用链表表示的非负整数， 然后将这个整数 再加上 1 。
     * 这些数字的存储是这样的：最高位有效的数字位于链表的首位 head 。
     * 示例 1:
     * 输入: head = [1,2,3]
     * 输出: [1,2,4]
     * 示例 2:
     * 输入: head = [0]
     * 输出: [1]
     * 提示：
     * 链表中的节点数在 [1, 100] 的范围内。
     * 0 <= Node.val <= 9
     * 由链表表示的数字不包含前导零，除了零本身。
     */
    public ListNode plusOne(ListNode head) {
        // 设置哨兵节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;

        // 找到最右边的不是9的节点
        while (head != null) {
            if (head.val != 9) notNine = head;
            head = head.next;
        }

        // 将最右边的不是9的节点加1, 并将其后面的节点都设置为0
        notNine.val++;
        notNine = notNine.next;

        // 将后面的节点都设置为0
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }

        return sentinel.val != 0 ? sentinel : sentinel.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
