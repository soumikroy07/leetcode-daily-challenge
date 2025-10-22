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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }

                list.add(curr.val);
            }

            if(flag){
                flag = false;
                Collections.reverse(list);
            }else{
                flag = true;
            }

            ans.add(list);
        }

        return ans;
    }
}