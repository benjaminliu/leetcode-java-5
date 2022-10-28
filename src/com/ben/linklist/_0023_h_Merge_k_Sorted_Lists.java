package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

import java.util.*;

public class _0023_h_Merge_k_Sorted_Lists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNodeUtil.create(1, 4, 5);
        lists[1] = ListNodeUtil.create(1, 3, 4);
        lists[2] = ListNodeUtil.create(2, 6);

        PrintUtil.printListNode(new Solution().mergeKLists(lists));
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            List<ListNode> curs = new ArrayList<>(lists.length);
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    curs.add(lists[i]);
                }
            }

            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;

            while (!curs.isEmpty()) {
                ListNode min = null;
                int minIdx = -1;
                for (int i = 0; i < curs.size(); i++) {
                    ListNode tmp = curs.get(i);
                    if (min == null || min.val > tmp.val) {
                        min = tmp;
                        minIdx = i;
                    }
                }
                cur.next = min;
                cur = cur.next;

                if (min.next == null) {
                    curs.remove(min);
                } else {
                    curs.set(minIdx, min.next);
                }
            }

            return dummy.next;
        }
    }

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return Integer.compare(o1.val, o2.val);
                }
            });

            for (ListNode n : lists) {
                if (n != null) {
                    minHeap.add(n);
                }
            }

            if (minHeap.isEmpty()) {
                return null;
            }

            ListNode head = minHeap.poll();

            ListNode cur = head;
            while (!minHeap.isEmpty()) {
                if (cur.next != null) {
                    minHeap.add(cur.next);
                }

                cur.next = minHeap.poll();
                cur = cur.next;
            }

            return head;
        }
    }

    class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            return partition(lists, 0, lists.length - 1);
        }

        private ListNode partition(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }

            int mid = (start + end) / 2;
            ListNode left = partition(lists, start, mid);
            ListNode right = partition(lists, mid + 1, end);
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }

            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;

            while (left != null && right != null) {
                if (left.val <= right.val) {
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                } else {
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                }
            }

            if (left != null) {
                cur.next = left;
            }
            if (right != null) {
                cur.next = right;
            }
            return dummy.next;
        }
    }
}
