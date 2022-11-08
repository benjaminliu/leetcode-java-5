package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0092_m_Reverse_Linked_List_II {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);

        PrintUtil.printListNode(new Solution().reverseBetween(head, 2, 4));
    }

    static class Solution {

        private ListNode successor;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            return help(head, left, right, 1);
        }

        private ListNode help(ListNode head, int left, int right, int cur) {
            if (head == null) {
                return null;
            }

            if (cur == right) {
                successor = head.next;
                return head;
            }

            if (cur < left) {
                ListNode next = help(head.next, left, right, cur + 1);
                head.next = next;
                return head;
            }

            ListNode next = head.next;

            ListNode newHead = help(head.next, left, right, cur + 1);

            next.next = head;

            if (cur == left) {
                head.next = successor;
            } else {
                head.next = null;
            }

            return newHead;
        }
    }

    static class Solution2 {

        private ListNode successor;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseFirstN(head, right);
            }

            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        private ListNode reverseFirstN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }

            ListNode next = head.next;

            ListNode newHead = reverseFirstN(head.next, n - 1);

            next.next = head;
            head.next = successor;
            return newHead;
        }
    }
}
