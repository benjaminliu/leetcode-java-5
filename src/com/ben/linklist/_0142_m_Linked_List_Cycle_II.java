package com.ben.linklist;

import com.ben.common.ListNode;

public class _0142_m_Linked_List_Cycle_II {

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    fast = dummy;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }

                    return fast;
                }
            }

            return null;
        }
    }
}
