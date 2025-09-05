class Solution {
    int dp[][];
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        dp = new int[n+1][n+1];
        return help(grid, 0, -1);
    }

    private int help(int grid[][], int i, int prev){
        if(i >= grid.length){
            return 0;
        }
        if(prev != -1 && dp[i][prev] != 0){
            return dp[i][prev];
        }

        int ans = Integer.MAX_VALUE;
        for (int j=0; j< grid.length; j++){
            if(j == prev){
                continue;
            }
            ans = Math.min(ans, help(grid, i+1, j) + grid[i][j]);

        }

        if(prev != -1){
            dp[i][prev] = ans;
        }

        return ans;
    }
}