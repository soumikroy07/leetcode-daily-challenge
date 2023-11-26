class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int edge[]: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(source, adj, new boolean[n], destination);
    }

    boolean dfs(int s, List<List<Integer>> adj, boolean visited[], int d){
        if(s == d){
            return true;
        }
        visited[s] = true;

        for(int nei: adj.get(s)){
            if(nei == d){
                return true;
            }
            if(!visited[nei]){
                if(dfs(nei, adj, visited, d)){
                    return true;
                }
            }
        }
        return false;
    }
}