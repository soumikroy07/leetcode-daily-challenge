class Solution {
    int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }

        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                for(int dir[]: dirs){
                    int new_i = curr[0] + dir[0];
                    int new_j = curr[1] + dir[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1){
                        grid[new_i][new_j] = 2;
                        q.add(new int[]{new_i, new_j});
                    }
                }
            }
            ans += 1;
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans > 0 ? ans-1 : ans;
    }
}