package com.ben.tree.bt;

import com.ben.common.TreeNode;

public class _0226_e_Invert_Binary_Tree {

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;
        }
    }

    class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            traverse(root);
            return root;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            traverse(root.left);
            traverse(root.right);
        }
    }
}
