package com.ben.tree.bt;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0889_m_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = new Solution().constructFromPrePost(preorder, postorder);

        System.out.println(root);
    }

    static class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }

            return helper(preorder, 0, preorder.length - 1, 0, postorder.length - 1, map);
        }

        private TreeNode helper(int[] preorder, int preStart, int preEnd, int postStart, int postEnd, Map<Integer, Integer> map) {
            if (preStart > preEnd) {
                return null;
            }

            int cur = preorder[preStart];
            TreeNode root = new TreeNode(cur);

            if (preStart == preEnd) {
                return root;
            }

            int leftChild = preorder[preStart + 1];
            int leftChildIdx = map.get(leftChild);

            //leftChildIdxDiff = leftChildSize - 1
            int leftChildIdxDiff = leftChildIdx - postStart;

            root.left = helper(preorder, preStart + 1, preStart + 1 + leftChildIdxDiff,
                    postStart, leftChildIdx, map);

            root.right = helper(preorder, preStart + 1 + leftChildIdxDiff + 1, preEnd,
                    leftChildIdx + 1, postEnd - 1, map);

            return root;
        }
    }
}
