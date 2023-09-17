class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        LinkedList<int[]> q = new LinkedList<>();
        int m = 1<<n;
        int[][] d = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(d[i],-1);
        for(int i=0;i<n;i++){
            q.offer(new int[]{i,1<<i});
            d[i][1<<i]=0;
        }
        while(!q.isEmpty()){
            int a = q.size();
            while(a>0){
                int[] r = q.poll();
                if(r[1]==m-1)return d[r[0]][r[1]];
                for(int i=0;i<graph[r[0]].length;i++){
                    int nm = r[1]|1<<graph[r[0]][i];
                    if(d[graph[r[0]][i]][nm]!=-1)continue;
                    d[graph[r[0]][i]][nm] = d[r[0]][r[1]]+1;
                    q.offer(new int[]{graph[r[0]][i],nm});
                }
                a--;
            }
        }
        return 1;
    }
}