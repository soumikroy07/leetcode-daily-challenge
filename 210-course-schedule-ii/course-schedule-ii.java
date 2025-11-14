class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }

        if(hasCycle(adj, numCourses)){
            return new int[]{};
        }

        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                topo(adj, i, visited, st);
            }
        }

        int i = numCourses - 1;
        int ans[] = new int[numCourses];

        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }

        return ans;
    }

    void topo(List<List<Integer>> adj, int node, boolean visited[], Stack<Integer> st){
        visited[node] = true;
        for(int nei: adj.get(node)){
            if(!visited[nei]){
                topo(adj, nei, visited, st);
            }
        }

        st.push(node);
    }

    boolean hasCycle(List<List<Integer>> adj, int n){
        boolean visited[] = new boolean[n];
        boolean recStack[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(dfs(adj, i, visited, recStack)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(List<List<Integer>> adj, int node, boolean visited[], boolean recStack[]){
        visited[node] = true;
        recStack[node] = true;

        for(int nei: adj.get(node)){
            if(!visited[nei]){
                if(dfs(adj, nei, visited, recStack)){
                    return true;
                }
            }else if(recStack[nei]){
                return true;
            }
        }

        recStack[node] = false;

        return false;
    }
}