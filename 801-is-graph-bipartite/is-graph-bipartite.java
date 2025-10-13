class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int v = graph.length;
        int color[] = new int[v];

        Arrays.fill(color, -1);

        for(int i=0; i<v; i++){
            if(color[i] == -1){
                if(!dfs(graph, i, color)){
                    return false;
                }
            }
        }

        return true;
        
    }

    boolean dfs(int graph[][], int node, int color[]){
        Queue<Integer> q = new LinkedList<>();
        color[node] = 0;
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei: graph[curr]){
                if(color[nei] == -1){
                    q.add(nei);
                    color[nei] = color[curr] == 1 ? 0 : 1;
                }else{
                    if(color[curr] == color[nei]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}