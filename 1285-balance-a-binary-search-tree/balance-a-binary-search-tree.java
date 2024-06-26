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
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return build(list, 0, list.size()-1);
    }

    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    TreeNode build(List<Integer> list, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, left, mid-1);
        root.right = build(list, mid+1, right);
        return root;
    }
}