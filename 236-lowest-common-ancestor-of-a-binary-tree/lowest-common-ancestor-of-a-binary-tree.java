/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            return helper(root, q, p);
        }
        return helper(root, p, q);
    }

    TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
        }
        if(root.val == p.val){
            return p;
        }
        if(root.val == q.val){
            return q;
        }
        
        TreeNode node1 = helper(root.left, p, q);
        TreeNode node2 = helper(root.right, p, q);
        if(node1 == null){
            return node2;
        }else if(node2 == null){
            return node1;
        }
        return root;
    }
}