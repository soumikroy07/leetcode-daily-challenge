class Solution {
    int parent[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int edge[]: edges){
            if(findParent(edge[0]) == findParent(edge[1])){
                return edge;
            }
            union(edge[0], edge[1]);
        }
        return null;
    }

    int findParent(int node){
        while(parent[node] != node){
            node = parent[node];
        }
        return node;
    }

    void union(int node1, int node2){
        int rootNode1 = findParent(node1);
        int rootNode2 = findParent(node2);

        if(rootNode1 != rootNode2){
            parent[rootNode1] = rootNode2;
        }
    }
}