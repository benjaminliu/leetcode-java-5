package com.ben.linklist;

import com.ben.common.ListNode;

public class _0021_e_Merge_Two_Sorted_Lists {

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode newCur = dummy;

            ListNode cur1 = list1;
            ListNode cur2 = list2;

            while (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    newCur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    newCur.next = cur2;
                    cur2 = cur2.next;
                }
                newCur = newCur.next;
            }

            if (cur1 != null) {
                newCur.next = cur1;
            }
            if (cur2 != null) {
                newCur.next = cur2;
            }

            return dummy.next;
        }
    }
}
