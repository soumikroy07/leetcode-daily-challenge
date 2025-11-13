/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        q.add(node);
        map.put(node, new Node(node.val, new ArrayList<Node>()));

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node curr = q.poll();
                for(Node neighbor: curr.neighbors){
                    if(!map.containsKey(neighbor)){
                        map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                        q.add(neighbor);
                    }
                    map.get(curr).neighbors.add(map.get(neighbor));
                }
            }
        }

        return map.get(node);
    }
}