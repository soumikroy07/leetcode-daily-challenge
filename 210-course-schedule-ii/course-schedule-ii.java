class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(hasCycle(adj, i, visited, recStack)){
                    return new int[]{};
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        Arrays.fill(visited, false);

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                build(adj, i, visited, st);
            }
        }

        int ans[] = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }

        return ans;
    }

    boolean hasCycle(List<List<Integer>> adj, int node, boolean visited[], boolean recStack[]){
        visited[node] = true;
        recStack[node] = true;

        for(int nei: adj.get(node)){
            if(!visited[nei]){
                if(hasCycle(adj, nei, visited, recStack)) return true;
            }else if(recStack[nei]){
                return true;
            }
        }

        recStack[node] = false;

        return false;
    }

    void build(List<List<Integer>> adj, int node, boolean visited[], Stack<Integer> st){
        visited[node] = true;

        for(int nei: adj.get(node)){
            if(!visited[nei]){
                build(adj, nei, visited, st);
            }
        }

        st.push(node);
    }
}