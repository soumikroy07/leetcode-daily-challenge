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
 
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        TreeNode start = null, end = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                map.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                map.put(curr.right, curr);
                q.add(curr.right);
            }
            if(curr.val == startValue){
                start = curr;
            }
            if(curr.val == destValue){
                end = curr;
            }
        }

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(start, ""));

        while(!qu.isEmpty()){
            Pair curr = qu.poll();
            if(curr.node == end){
                return curr.dir;
            }

            if(curr.node.left != null){
                qu.add(new Pair(curr.node.left, curr.dir + 'L'));
            }

            if(curr.node.right != null){
                qu.add(new Pair(curr.node.right, curr.dir + 'R'));
            }

            if(map.get(curr.node) != null){
                qu.add(new Pair(map.get(curr.node), curr.dir + 'U'));
            }
        }
        return "";
    }
}

class Pair{
    TreeNode node;
    String dir;

    Pair(TreeNode n, String d){
        node = n;
        dir = d;
    }
}
*/

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
    private boolean find(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val) 
            return true;
        if (n.left != null && find(n.left, val, sb))
            sb.append("L");
        else if (n.right != null && find(n.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        find(root, startValue, s);
        find(root, destValue, d);
        int i = 0, max_i = Math.min(d.length(), s.length());
        while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            ++i;
        return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
    }
}