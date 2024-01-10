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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        parent.put(root, null);
        q.add(root);
        TreeNode target = null;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(start == curr.val){
                target = curr;
            }
            if(curr.left != null){
                q.add(curr.left);
                parent.put(curr.left, curr);
            }
            if(curr.right != null){
                q.add(curr.right);
                parent.put(curr.right, curr);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode curr = q.poll();
                visited.add(curr);
                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                }
                if(parent.get(curr) != null && !visited.contains(parent.get(curr))){
                    q.add(parent.get(curr));
                }
            }
            time++;
        }

        return time-1;
    }
}