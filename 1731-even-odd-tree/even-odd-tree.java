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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);


        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            if(level == 0){
                if(list.get(0) % 2 != 1){
                    return false;
                }
            }else if(level % 2 == 1){
                for(int i=0; i<list.size(); i++){
                    if(list.get(i) % 2 != 0){
                        return false;
                    }
                }
                for(int i=0; i<list.size()-1; i++){
                    if(list.get(i) <= list.get(i+1)){
                        return false;
                    }
                }
            }else{
                for(int i=0; i<list.size(); i++){
                    if(list.get(i) % 2 == 0){
                        return false;
                    }
                }
                for(int i=0; i<list.size()-1; i++){
                    if(list.get(i) >= list.get(i+1)){
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
}