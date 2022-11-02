package com.ben.linklist;

import com.ben.common.ListNode;

public class _0876_m_Middle_of_the_Linked_List {

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            while ( fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow.next;
        }
    }
}
