package com.ben.tree.bt;

import com.ben.common.TreeNode;

public class _0654_m_Maximum_Binary_Tree {

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildTree(nums, 0, nums.length - 1);
        }

        private TreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            if (start == end) {
                return new TreeNode(nums[start]);
            }
            int max = nums[start];
            int maxIdx = start;

            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIdx = i;
                }
            }

            TreeNode root = new TreeNode(max);
            root.left = buildTree(nums, start, maxIdx - 1);
            root.right = buildTree(nums, maxIdx + 1, end);

            return root;
        }
    }
}
