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
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root = null;
        int i = 0;
        int n = traversal.length();
        Stack<TreeNode> st = new Stack<>();
        while(i < n){
            int value = 0, depth = 0;
            while(i < n && traversal.charAt(i) == '-'){
                depth++;
                i++;
            }

            while(i < n && traversal.charAt(i) != '-'){
                value = 10 * value + (traversal.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(value);
            if(!st.isEmpty()){
                while(st.size() > depth){
                    st.pop();
                }
                if(st.peek().left == null){
                    st.peek().left = node;
                }else{
                    st.peek().right = node;
                }
            }else{
                root = node;
            }
            st.push(node);
        }
        return root;
    }
}