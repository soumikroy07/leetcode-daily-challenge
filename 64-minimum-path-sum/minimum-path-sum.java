class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length+1][grid[0].length+1];
        return help(grid, 0, 0);
    }

    int help(int arr[][], int i, int j){
        if(i == arr.length - 1 && j == arr[0].length - 1){
            return arr[i][j];
        }

        if(i >= arr.length || j >= arr[0].length){
            return Integer.MAX_VALUE/2;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int ans = 0;

        // ans += help(arr, i+1, j);
        // ans += help(arr, i, j+1);
        // ans = Math.min(help(arr, i, j+1) + arr[i][j], Math.min(ans, help(arr, i+1, j) + arr[i][j]));
        // // int ans = 
        // return dp[i][j]=ans;

        return dp[i][j]=Math.min(help(arr, i, j+1) + arr[i][j], help(arr, i+1, j) + arr[i][j]);
    }
}