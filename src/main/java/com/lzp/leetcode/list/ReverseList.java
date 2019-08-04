package com.lzp.leetcode.list;

import com.lzp.leetcode.t203.ListNode;

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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

