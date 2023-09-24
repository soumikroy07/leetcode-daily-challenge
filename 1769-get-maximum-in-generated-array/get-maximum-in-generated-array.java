class Solution {
    public int getMaximumGenerated(int n) {
        int dp[] = new int[n+1];
        if(n == 0 || n == 1){
            return n;
        }
        dp[1] = 1;
        int max = 0;
        for(int i=2; i<=n; i++){
            if(i % 2 == 0){
                int idx = i / 2;
                dp[i] = dp[idx];
            }else{
                int idx = i / 2;
                dp[i] = dp[idx] + dp[idx+1];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}