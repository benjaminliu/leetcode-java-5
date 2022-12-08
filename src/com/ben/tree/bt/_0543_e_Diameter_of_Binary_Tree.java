package com.ben.tree.bt;

import com.ben.common.TreeNode;

public class _0543_e_Diameter_of_Binary_Tree {

    class Solution {

        private int max;

        public int diameterOfBinaryTree(TreeNode root) {
            max = 0;

            helper(root);

            return max;
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = helper(root.left);
            int right = helper(root.right);

            int diameter = left + right;
            max = Math.max(max, diameter);

            return Math.max(left, right) + 1;
        }
    }
}
