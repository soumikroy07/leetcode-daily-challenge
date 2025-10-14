class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int processed[] = new int[n];
        boolean safe[] = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(processed[i] == 0){
                checkSafeState(graph, i, processed, safe);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(safe[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    boolean checkSafeState(int graph[][], int node, int processed[], boolean safe[]){
        processed[node] = 1;
        boolean isSafe = true;

        for(int nei: graph[node]){
            if(processed[nei] == 0){
                isSafe &= checkSafeState(graph, nei, processed, safe);
            }else if(processed[nei] == 1){
                return safe[nei] = false;
            }else{
                isSafe &= safe[nei];
            }
        }

        processed[node] = 2;
        return safe[node] = isSafe;
    }
}