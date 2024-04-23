class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int degree[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            degree[edge[0]]++;
            degree[edge[1]]++;

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(degree[i] == 1){
                q.add(i);
            }
        }

        while(n > 2){
            int size = q.size();
            n = n - size;

            while(size > 0){
                int curr = q.poll();
                for(int nei: adj.get(curr)){
                    degree[nei]--;
                    if(degree[nei] == 1){
                        q.add(nei);
                    }
                }
                size--;
            }
        }

        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;
    }
}