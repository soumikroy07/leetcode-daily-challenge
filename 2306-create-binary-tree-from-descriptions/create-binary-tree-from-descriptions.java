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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for(int d[] : descriptions){
            int val = d[0];
            int child = d[1];
            int isLeft = d[2];
            TreeNode node = null, childNode = null;
            if(map.get(val) == null){
                node = new TreeNode(val);
            }else{
                node = map.get(val);
            }
            
            if(map.get(child) == null){
                childNode = new TreeNode(child);
            }else{
                childNode = map.get(child);
            }

            if(isLeft == 1){
                node.left = childNode;
            }else{
                node.right = childNode;
            }
            map.put(val, node);
            map.put(child, childNode);
        }
        /*
        TreeNode ans = null;
        int count = 0;
        for(Map.Entry<Integer, TreeNode> m : map.entrySet()){
            int nodes = getNodes(m.getValue());
            if(nodes > count){
                count = nodes;
                ans = m.getValue();
            }
        }
        return ans;
        */

        Set<Integer> set = new HashSet<>();
        for(int d[] : descriptions){
            set.add(d[1]);
        }

        for(int d[] : descriptions){
            if(!set.contains(d[0])){
                return map.get(d[0]);
            }
        }
        return null;
    }

    int getNodes(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1+getNodes(node.left)+getNodes(node.right);
    }
}