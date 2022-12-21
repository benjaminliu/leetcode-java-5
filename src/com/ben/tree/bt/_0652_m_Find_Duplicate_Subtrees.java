package com.ben.tree.bt;

import com.ben.common.TreeNode;

import java.util.*;

public class _0652_m_Find_Duplicate_Subtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        List<TreeNode> res = new Solution().findDuplicateSubtrees(root);

        System.out.println(res.size());
    }

    static class Solution {
        private static final String SEP = "-";

        private Map<String, Integer> map;
        private List<TreeNode> list;


        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            map = new HashMap<>();
            list = new ArrayList<>();

            postOrderTraverse(root);
            return list;
        }

        private String postOrderTraverse(TreeNode root) {
            if (root == null) {
                return "#";
            }

            String left = postOrderTraverse(root.left);
            String right = postOrderTraverse(root.right);

            String value = left + SEP + right + SEP + root.val;

            int count = map.getOrDefault(value, 0);
            if (count == 1) {
                //Find duplicate tree
                list.add(root);
            }
            map.put(value, count + 1);
            return value;
        }
    }
}
