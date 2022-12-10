package com.ben.tree.bt;


import java.util.LinkedList;
import java.util.Queue;

public class _0116_m_Populating_Next_Right_Pointers_in_Each_Node {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node newRoot = new Solution().connect(root);

        System.out.println("a");
    }

    static class Solution {
        public Node connect(Node root) {
            Queue<Node> layer = new LinkedList<>();
            layer.offer(root);

            while (!layer.isEmpty()) {
                int size = layer.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node cur = layer.poll();
                    if (cur == null) {
                        continue;
                    }

                    if (cur.left != null) {
                        layer.offer(cur.left);
                    }
                    if (cur.right != null) {
                        layer.offer(cur.right);
                    }

                    if (pre != null) {
                        pre.next = cur;
                    }
                    pre = cur;
                }
            }
            return root;
        }
    }

    static class Solution2 {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            connect(root.left, root.right);
            return root;
        }

        private void connect(Node left, Node right) {
            if (left == null || right == null) {
                return;
            }

            left.next = right;

            connect(left.left, left.right);
            connect(left.right, right.left);
            connect(right.left, right.right);
        }
    }
}
