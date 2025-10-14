class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int pre[]: prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }

        if(hasCycle(adj, numCourses)){
            return new int[]{};
        }

        boolean visited[] = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<numCourses; i++){
            if(!visited[i]){
                dfs(adj, i, visited, st);
            }
        }

        int ans[] = new int[st.size()];

        int i=st.size()-1;
        while (!st.isEmpty()){
            ans[i--] = st.pop();
        }
        return ans;
    }

    private static void dfs(List<List<Integer>> adj, int node, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (int nei: adj.get(node)){
            if(!visited[nei]){
                dfs(adj, nei, visited, st);
            }
        }
        st.push(node);
    }

    private static boolean hasCycle(List<List<Integer>> adj, int numCourses) {
        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];
        for (int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfs(adj, i, visited, recStack)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int nei: adj.get(node)){
            if(!visited[nei]){
                if(dfs(adj, nei, visited, recStack)){
                    return true;
                }
            } else if (recStack[nei]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }
}