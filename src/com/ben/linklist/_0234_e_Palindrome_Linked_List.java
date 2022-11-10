package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0234_e_Palindrome_Linked_List {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(1, 2);

        PrintUtil.printLn(new Solution().isPalindrome(head));
    }

    static class Solution {
        private ListNode left;

        public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }

            left = head;
            return traverse(head.next);
        }

        private boolean traverse(ListNode right) {
            //We meet in the middle
            if (left == right) {
                return true;
            }

            if (right.next != null) {
                boolean res = traverse(right.next);
                if (res == false) {
                    return false;
                }
            }

            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            return true;
        }
    }
}
