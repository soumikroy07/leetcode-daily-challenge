class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+1];
        return help(n);
    }
    int help(int n){
        if(n == 1 || n == 2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = help(n-1)+help(n-2);
    
    }
}