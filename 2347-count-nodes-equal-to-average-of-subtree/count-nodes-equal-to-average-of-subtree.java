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
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        tree(root);
        return ans;
    }

    void tree(TreeNode root){
        if(root == null){
            return;
        }
        tree(root.left);
        int count = getTotal(root);
        int sum = getSum(root);
        if(sum / count == root.val){
            ans++;
        }
        tree(root.right);
    }

    int getTotal(TreeNode root){
        if(root == null){
            return 0;
        }
        return getTotal(root.left) + getTotal(root.right) + 1;
    }
    int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSum(root.left) + getSum(root.right) + root.val;
    }
}