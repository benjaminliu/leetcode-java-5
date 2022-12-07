package com.ben.tree.bt;

import com.ben.common.TreeNode;

public class _0104_m_Maximum_Depth_of_Binary_Tree {

    class Solution {
        private int max;

        public int maxDepth(TreeNode root) {
            max = 0;
            helper(root, 0);
            return max;
        }

        private void helper(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            depth++;
            max = Math.max(max, depth);

            helper(root.left, depth);
            helper(root.right, depth);
        }
    }

    class Solution2 {
        public int maxDepth(TreeNode root) {

            return helper(root);
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = helper(root.left);
            int right = helper(root.right);

            return Math.max(left, right) + 1;
        }
    }
}
