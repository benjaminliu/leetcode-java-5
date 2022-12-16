package com.ben.tree.bt;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0106_m_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};

        TreeNode root = new Solution().buildTree(inorder, postorder);

        System.out.println(root.val);
    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(postorder, 0, postorder.length - 1, 0, map);
        }

        private TreeNode helper(int[] postorder, int postStart, int postEnd, int inStart, Map<Integer, Integer> map) {
            if (postStart > postEnd) {
                return null;
            }
            int cur = postorder[postEnd];
            TreeNode root = new TreeNode(cur);

            if (postStart == postEnd) {
                //Only 1 node
                return root;
            }

            int idx = map.get(cur);
            int count = idx - inStart - 1;

            root.left = helper(postorder, postStart, postStart + count, inStart, map);
            root.right = helper(postorder, postStart + count + 1, postEnd - 1, idx + 1, map);

            return root;
        }
    }
}
