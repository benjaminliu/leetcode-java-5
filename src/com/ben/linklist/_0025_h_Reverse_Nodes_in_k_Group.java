package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0025_h_Reverse_Nodes_in_k_Group {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);

        PrintUtil.printListNode(new Solution2().reverseKGroup(head, 2));
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;

            int count = 0;
            while (cur != null) {
                count++;
                if (count == k) {
                    break;
                }

                cur = cur.next;
            }

            //linked list node count is less than k, do not revert
            if (cur == null) {
                return head;
            }

            ListNode nextGroupHead = reverseKGroup(cur.next, k);

            cur.next = null;
            ListNode currentGroupHead = reverseList(head);

            //Head become the tail of current group
            head.next = nextGroupHead;

            return currentGroupHead;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next = head.next;

            ListNode newHead = reverseList(head.next);

            next.next = head;
            head.next = null;
            return newHead;
        }
    }

    static class Solution2 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    return head;
                }
                cur = cur.next;
            }

            ListNode newHead = reverseList(head, cur);
            head.next = reverseKGroup(cur, k);
            return newHead;
        }

        //[from, to), include from, exclude to
        public ListNode reverseList(ListNode from, ListNode to) {
            ListNode pre, cur, nxt;
            pre = null;
            cur = from;

            while (cur != to) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            return pre;
        }
    }
}
