package com.ben.linklist;

import com.ben.common.ListNode;

public class _0141_e_Linked_List_Cycle {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }
}
