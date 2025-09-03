class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1){
            return 0;
        }
        dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        return help(obstacleGrid, 0, 0);
    }

    int help(int arr[][], int i, int j){
        if(i == arr.length - 1 && j == arr[0].length - 1){
            return 1;
        }

        if(i >= arr.length || j >= arr[0].length || arr[i][j] == 1){
            return 0;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int ans = 0;

        ans += help(arr, i+1, j);
        ans += help(arr, i, j+1);

        return dp[i][j]=ans;
    }
}