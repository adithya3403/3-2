// j. Write a JAVA Program to find the lowest common ancestor of a binary tree

// Given a binary tree, find the lowest common ancestor(LCA) of two given nodes in the tree.
// Given the following binary tree:root=[3,5,1,6,2,0,8,null,null,7,4]

// Example 1:
// Input:root=[3,5,1,6,2,0,8,null,null,7,4],p=5,q=1
// Output:3
// Explanation:The LCA of nodes 5 and 1 is 3.

// Example 2:
// Input:root=[3,5,1,6,2,0,8,null,null,7,4],p=5,q=4
// Output:5
// Explanation:The LCA of nodes 5 and 4 is 5,since a node can be a descendant
// of itself according to the LCA definition.

// Note:All of the nodes' values will be unique. p and q are different and both
// values will exist in the binary tree.

import java.util.*;

class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;

    TreeNode(String val) {
        this.val = val;
    }
}


public class p1j {
    public static void main(String[] args) {
        String[] elements = {"3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4"};
        TreeNode root = new TreeNode(elements[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < elements.length) {
            TreeNode curr = queue.poll();
            if (!elements[i].equals("null"))
                queue.add(curr.left = new TreeNode(elements[i]));
            i++;
            if (!elements[i].equals("null"))
                queue.add(curr.right = new TreeNode(elements[i]));
            i++;
        }
        TreeNode p = new TreeNode("5");
        TreeNode q = new TreeNode("1");
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val);
        p = new TreeNode("5");
        q = new TreeNode("4");
        lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val.equals(p.val) || root.val.equals(q.val))
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left != null && right != null) ? root : (left != null) ? left : right;
    }
}
