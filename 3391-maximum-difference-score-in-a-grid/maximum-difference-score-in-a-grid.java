class Solution {
    int dp[][];
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        dp = new int[m+1][n+1];
        for(int d[]: dp){
            Arrays.fill(d, -1);
        }
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, solve(grid, i, j));
                if(i+1 < m) max1 = Math.max(grid.get(i+1).get(j) - grid.get(i).get(j), max1);
                if(j+1 < n) max1 = Math.max(grid.get(i).get(j+1) - grid.get(i).get(j), max1);
            }
        }

        if(max == 0) return max1;

        return max;
    }

    int solve(List<List<Integer>> grid, int i, int j){
        if(i >= grid.size() || j >= grid.get(i).size()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int pick1 = Integer.MIN_VALUE, pick2 = Integer.MIN_VALUE;

        if(i+1 < grid.size()){
            pick1 = (grid.get(i+1).get(j) - grid.get(i).get(j)) + solve(grid, i+1, j);
        }

        if(j+1 < grid.get(i).size()){
            pick2 = (grid.get(i).get(j+1) - grid.get(i).get(j)) + solve(grid, i, j+1);
        }

        return dp[i][j] = Math.max(0, Math.max(pick1, pick2));
    }
}