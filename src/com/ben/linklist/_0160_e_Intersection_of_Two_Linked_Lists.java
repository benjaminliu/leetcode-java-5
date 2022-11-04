package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0160_e_Intersection_of_Two_Linked_Lists {

    public static void main(String[] args) {

        ListNode common = ListNodeUtil.create(8, 4, 5);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        PrintUtil.printListNode(new Solution().getIntersectionNode(headA, headB));
    }

    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;
            //If not intersection,  curA and curB will be null at the same time after switch
            while (curA != curB) {
                if (curA == null) {
                    curA = headB;
                } else {
                    curA = curA.next;
                }

                if (curB.next == null) {
                    curB = headA;
                } else {
                    curB = curB.next;
                }
            }

            return curA;
        }
    }
}
