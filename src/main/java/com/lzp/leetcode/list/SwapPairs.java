package com.lzp.leetcode.list;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {
    /**
     * 解答方法1 -- 采用标志位法
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        boolean flag = true;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode prev = dummyHead;
        while (cur != null) {
            if (flag && cur.next != null) {
                prev.next = cur.next;
                cur.next = cur.next.next;
                prev.next.next = cur;
            } else {
                cur = cur.next;
            }
            prev = prev.next;
            flag = !flag;
        }
        return dummyHead.next;
    }

    /**
     * 更简洁的迭代法--不采用标志位
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            ListNode cur = prev.next;
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            prev = cur;
        }
        return dummyHead.next;
    }

    /**
     * 递归法
     * <p>
     * 1 -> 2 -> 3 -> null
     * 步骤
     * 1 -> 3
     * 2 -> 1
     * ==> 2 -> 1 -> 3
     *
     * </p>
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs3(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 暂存head下一个节点
        ListNode temp = head.next;
        // 当前节点next指针指向temp的下一个节点
        head.next = swapPairs3(temp.next);
        // temp的next指针指向head
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = null;
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = null;

        print(swapPairs2(head));
    }

    public static void print(ListNode head) {
        while (true) {
            if (head == null) {
                break;
            }
            System.out.print(head.val + " ");
            head = head.next;

        }

    }
}

