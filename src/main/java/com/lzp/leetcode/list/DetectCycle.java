package com.lzp.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {
    /**
     * Set去重法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 采用快慢指针法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        fast = head;
        while(hasCycle){
            if(slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }
}
