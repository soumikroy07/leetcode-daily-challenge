class Solution {
    int m, n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j] == 1){
                    if(dfs(grid1, grid2, i, j)){
                        ans += 1;
                    }
                }
            }
        }

        return ans;
    }

    boolean dfs(int grid1[][], int grid2[][], int i, int j){
        if(i >= 0 && i < m && j >= 0 && j < n && grid2[i][j] == 1){
            if(grid1[i][j] != grid2[i][j]){
                return false;
            }
            grid2[i][j] = -1;
            boolean left = dfs(grid1, grid2, i, j-1);
            boolean right = dfs(grid1, grid2, i, j+1);
            boolean top = dfs(grid1, grid2, i-1, j);
            boolean down = dfs(grid1, grid2, i+1, j);
            if(!left || !right || !top || !down){
                return false;
            }
        }

        return true;
    }
}