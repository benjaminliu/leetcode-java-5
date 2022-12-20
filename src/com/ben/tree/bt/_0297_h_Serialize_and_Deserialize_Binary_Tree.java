package com.ben.tree.bt;

import com.ben.common.TreeNode;

public class _0297_h_Serialize_and_Deserialize_Binary_Tree {

    public class Codec {

        private static final String SEP = ",";
        private static final String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            traverse(root, sb);
            return sb.toString();
        }

        private void traverse(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            sb.append(root.val).append(SEP);

            traverse(root.left, sb);
            traverse(root.right, sb);
        }

        private int idx;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(SEP);

            idx = 0;

            return buildTree(nodes);
        }

        private TreeNode buildTree(String[] nodes) {
            String val = nodes[idx];
            idx++;
            if (NULL.equals(val)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }
    }

}
