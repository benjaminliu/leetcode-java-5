package com.ben.tree.bt;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0105_m_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = new Solution().buildTree(preorder, inorder);
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return helper(preorder, 0, preorder.length - 1, 0, map);
        }

        private TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, Map<Integer, Integer> map) {
            if (preStart > preEnd) {
                return null;
            }
            int cur = preorder[preStart];
            TreeNode root = new TreeNode(cur);

            if (preStart == preEnd) {
                //Only 1 node
                return root;
            }

            int idx = map.get(cur);
            int lastDescendentIdx = idx - 1;

            //idxDiff = count - 1
            int idxDiff = lastDescendentIdx - inStart;

            root.left = helper(preorder, preStart + 1, preStart + 1 + idxDiff, inStart, map);
            root.right = helper(preorder, preStart + 1 + idxDiff + 1, preEnd, idx + 1, map);

            return root;
        }
    }
}
