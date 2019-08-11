package com.lzp.leetcode.list;

/**
 * 反转链表的两种解决方法
 * 1. 迭代法
 * 2. 递归法
 * LeetCode 206T
 */
public class ReverseList {
    /**
     * 迭代法
     * 时间复杂度O(n) 空间复杂度0(1)
     *
     * @param head 以head为头节点的链表
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 定义两个指针，分别指向当前节点和前一个节点
        ListNode cur = head;
        ListNode prev = null;
        // 1 -> 2 -> 3 -> null
        // 3 -> 2 -> 1 -> null
        // 迭代
        while (cur != null) {
            // temp用于暂存当前节点的下一个节点
            ListNode temp = cur.next;
            // 当前节点cur的下一节点指向prev
            cur.next = prev;
            // prev指向当前节点
            prev = cur;
            // 当前节点后移
            cur = temp;
        }
        return prev;
    }

    /**
     * 递归法
     * 时间复杂度O(n)--链表长度是n
     * 空间复杂度0(n)--使用递归，会用到隐式栈空间，递归深度为n
     *
     * @param head 以head为头节点的链表
     * @return
     */
    public ListNode reverseListR(ListNode head) {
        // 终止条件：当当前节点为最后一个节点或null时，
        // 此时没有子问题，不需要递归，递归终止
        if (head == null || head.next == null) {
            return head;
        }
        // 原链表：1 -> 2 -> null
        // 当前链表：1 -> 2 <- null, subList = null -> 2
        // 1.next.next = 1, 1.next = null, 此时subList = null -> 2 -> 1
        ListNode subList = reverseListR(head.next);
        // 对于原链表，当前节点下一个节点指向当前节点
        head.next.next = head;
        // 子链表末尾指向null
        head.next = null;
        return subList;
    }
}
