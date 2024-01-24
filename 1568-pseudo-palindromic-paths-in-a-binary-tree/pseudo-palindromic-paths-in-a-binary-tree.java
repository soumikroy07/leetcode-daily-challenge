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
    private int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int freq[] = new int[10];
        helper(root, freq);
        return ans;
    }
    
    void helper(TreeNode root, int freq[]){
        if(root == null) return;
        
        freq[root.val]++;
        
        if(root.left == null && root.right == null){
            if(isPalindrome(freq)) ans++;
        }
        
        helper(root.left, freq);
        helper(root.right, freq);
        
        freq[root.val]--;
    }
    
    boolean isPalindrome(int freq[]){
        int count = 0;
        for(int el : freq){
            if(el % 2 != 0){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }
        return true;
    }
}