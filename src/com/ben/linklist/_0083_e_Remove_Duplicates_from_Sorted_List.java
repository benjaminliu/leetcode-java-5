package com.ben.linklist;

import com.ben.common.ListNode;

public class _0083_e_Remove_Duplicates_from_Sorted_List {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode cur  = head;

            while (cur.next != null){
                if(cur.next.val == cur.val){
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }

            return head;
        }
    }
}
