class Solution {
    int mod = (int)(1e9+7);
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1]; 
        dp[0][0] = 1;
		//how many possibility can i dices sum up to j;
        for(int i = 1; i <= d; i++) {
            for(int j = 1; j<= target; j++) {
                if(j > i * f) {
                   continue;
                    //If j is larger than largest possible sum of i dices, there is no possible ways.        
                } else {
                    //watch out below condition, or NPE
                    for(int k = 1; k <= f && k <= j ; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD; 
                    }
                }
            }
        }
        return dp[d][target];
    }
}

/*

recurssive approch

class Solution {
    int count = 0, mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        if(n == 0){
            if(target == 0){
                count++;
            }
            return 0;
        }
        
        for(int i=1; i<=k; i++){
            numRollsToTarget(n-1, k, target - i);
        }
        
        return count%mod;
    }
}

*/