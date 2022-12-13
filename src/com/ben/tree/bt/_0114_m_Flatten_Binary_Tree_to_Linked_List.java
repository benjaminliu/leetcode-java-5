package com.ben.tree.bt;

import com.ben.common.TreeNode;

public class _0114_m_Flatten_Binary_Tree_to_Linked_List {

    class Solution {

        private TreeNode head;
        private TreeNode cur;

        public void flatten(TreeNode root) {
            head = new TreeNode(-1);
            cur = head;
            traverse(root);
            root = head.right;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = null;

            cur.right = root;
            cur = cur.right;

            traverse(left);
            traverse(right);
        }
    }

    class Solution2 {

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;
            flatten(left);
            flatten(right);

            root.left = null;

            if (left != null) {
                root.right = left;

                TreeNode cur = left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = right;
            } else {
                root.right = right;
            }
        }
    }

    class Solution3 {
        TreeNode next;

        public void flatten(TreeNode root) {
            next = null;
            postOrderTraverse(root);
        }

        private void postOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            postOrderTraverse(root.right);
            postOrderTraverse(root.left);

            root.right = next;
            root.left = null;

            next = root;
        }
    }
}
