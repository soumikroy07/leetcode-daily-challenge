class Solution {
    int m, n;

    int dirs[][];
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }

    int dfs(int grid[][], int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int ans = 0;
        for(int dir[]: dirs){
            ans += dfs(grid, i + dir[0], j + dir[1]);
        }

        return ans + 1;
    }
}