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
    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return diff;
    }

    int[] helper(TreeNode root){
        if(root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        if(root.left == null && root.right == null){
            return new int[]{root.val, root.val};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);

        diff = Math.max(diff, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return new int[]{min, max};
    }

}