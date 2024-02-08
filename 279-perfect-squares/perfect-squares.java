class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=1; i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                int remaining = i - j*j;
                if(dp[remaining] < min){
                    min = dp[remaining];
                }
            }
            
            dp[i] = min+1;
        }
        
        return dp[n];
    }
}