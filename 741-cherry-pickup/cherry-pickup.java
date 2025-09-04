class Solution {
    int dp[][][];
    public int cherryPickup(int[][] grid) {
        dp = new int[50][50][50];
        for(int dpp[][]: dp){
            for(int d[]: dpp){
                Arrays.fill(d, -1);
            }
        }
        return help(grid, 0, 0, 0, 0, grid.length) < 0 ? 0 : help(grid, 0, 0, 0, 0, grid.length);
    }

    private int help(int grid[][], int r1, int c1, int r2, int c2, int n){
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        r1 = r2+c2-c1;
        if(dp[c1][r2][c2] != -1){
            return dp[c1][r2][c2];
        }

        int p = grid[r1][c1];
        int q = grid[r2][c2];
        int cherryCount = 0;
        if(r1 == r2 && c1 == c2){
            cherryCount += grid[r1][c1];
            if(r1 == n-1 && c1 == n-1){
                dp[c1][r2][c2] = grid[r1][c1];
                return dp[c1][r2][c2];
            }
            grid[r1][c1] = 0;
        }else {
            cherryCount += (grid[r1][c1] + grid[r2][c2]);
            grid[r1][c1] = 0;
            grid[r2][c2] = 0;
        }

        int p1 = help(grid, r1+1, c1, r2+1, c2, n);
        int p2 = help(grid, r1, c1+1, r2+1, c2, n);
        int p3 = help(grid, r1+1, c1, r2, c2+1, n);
        int p4 = help(grid, r1, c1+1, r2, c2+1, n);

        grid[r1][c1] = p;
        grid[r2][c2] = q;
//        dp[c1][r2][c2] = Math.max(Math.max(p1, p2), Math.max(p3, p4));

        return dp[c1][r2][c2] = cherryCount + Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }
}