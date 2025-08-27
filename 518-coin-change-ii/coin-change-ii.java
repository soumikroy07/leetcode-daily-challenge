class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][coins.length+1];
        for(int d[]: dp){
            Arrays.fill(d, -1);
        }
        return help(coins, amount, 0);
    }

    int help(int coins[], int amount, int i){
        if(amount == 0){
            return 1;
        }

        if(amount < 0 || i >= coins.length){
            return 0;
        }

        if(dp[amount][i] != -1){
            return dp[amount][i];
        }

        int ans1 = help(coins, amount-coins[i], i);
        int ans2 = help(coins, amount, i+1);
        return dp[amount][i] = ans1 + ans2;
    }
}