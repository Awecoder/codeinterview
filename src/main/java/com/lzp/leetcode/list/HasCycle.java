package com.lzp.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 */
public class HasCycle {
    /**
     * 方法1：利用set判断节点是否唯一
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (head != null) {
            if (listNodeSet.contains(head)) {
                return true;
            }
            listNodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 方法2：利用快慢指针判断是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            if(slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
