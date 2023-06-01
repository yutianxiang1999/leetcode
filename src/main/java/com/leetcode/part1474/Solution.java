package com.leetcode.part1474;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);
        ListNode listNode = solution.deleteNodes(head, 2, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 给定链表 head 和两个整数 m 和 n. 遍历该链表并按照如下方式删除节点:
     * <p>
     * 开始时以头节点作为当前节点.
     * 保留以当前节点开始的前 m 个节点.
     * 删除接下来的 n 个节点.
     * 重复步骤 2 和 3, 直到到达链表结尾.
     * 在删除了指定结点之后, 返回修改过后的链表的头节点.
     * 示例 1:
     * 输入: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
     * 输出: [1,2,6,7,11,12]
     * 解析: 保留前(m = 2)个结点, 也就是以黑色节点表示的从链表头结点开始的结点(1 ->2).
     * 删除接下来的(n = 3)个结点(3 -> 4 -> 5), 在图中以红色结点表示.
     * 继续相同的操作, 直到链表的末尾.
     * 返回删除结点之后的链表的头结点.
     * 示例 2:
     * 输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
     * 输出: [1,5,9]
     * 解析: 返回删除结点之后的链表的头结点.
     * 示例 3:
     * 输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
     * 输出: [1,2,3,5,6,7,9,10,11]
     * 示例 4:
     * 输入: head = [9,3,7,7,9,10,8,2], m = 1, n = 2
     * 输出: [9,7,8]
     * 提示:
     * 链表中节点数目在范围 [1, 104] 内
     * 1 <= Node.val <= 106
     * 1 <= m, n <= 1000
     */
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        while (cur != null) {
            for (int i = 0; i < m && cur != null; i++) {
                cur = cur.next;
            }
            for (int i = 0; i < n && cur != null && cur.next != null; i++) {
                cur.next = cur.next.next;
            }
        }
        return dummyHead.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
