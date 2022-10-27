package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.PrintUtil;

public class _0086_m_Partition_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        PrintUtil.printListNode(new Solution2().partition(head, 3));
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode slow = dummy;

            //Find first node that greater or equal to x
            while (slow.next != null) {
                if (slow.next.val >= x) {
                    break;
                }
                slow = slow.next;
            }

            ListNode fast = slow;
            while (fast.next != null) {
                if (fast.next.val >= x) {
                    fast = fast.next;
                    continue;
                }

                ListNode tmp = fast.next;
                //Remove tmp
                fast.next = fast.next.next;
                tmp.next = slow.next;
                slow.next = tmp;
                slow = slow.next;
            }

            return dummy.next;
        }
    }


    static class Solution2 {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }

            ListNode dummySmall = new ListNode(-1);
            ListNode dummyBig = new ListNode(-1);
            ListNode curSmall = dummySmall;
            ListNode curBig = dummyBig;

            ListNode cur = head;

            while (cur != null) {
                if (cur.val < x) {
                    curSmall.next = cur;
                    curSmall = curSmall.next;
                    cur = cur.next;
                    curSmall.next = null;
                } else {
                    curBig.next = cur;
                    curBig = curBig.next;
                    cur = cur.next;
                    curBig.next = null;
                }
            }

            curSmall.next = dummyBig.next;

            return dummySmall.next;
        }
    }
}
