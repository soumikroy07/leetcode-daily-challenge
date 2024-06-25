/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public TreeNode bstToGst(TreeNode root) {
        help(root);
        return root;
    }
    void help(TreeNode root){
        if(root == null){
            return;
        }
        help(root.right);
        ans += root.val;
        root.val = ans;
        help(root.left);
    }
}