class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        dp = new int[10001][13];
        return help(coins, amount, 0) >= 100001 ? -1 : help(coins, amount, 0);
    }

    public int help(int coins[], int amount, int i){
        if(amount == 0){
            return 0;
        }

        if(amount < 0 || i >= coins.length){
            return 100001;
        }

        if(dp[amount][i] != 0){
            return dp[amount][i];
        }

        int ans1 = help(coins, amount-coins[i], i) + 1;
        int ans2 = help(coins, amount, i+1);

        return dp[amount][i]=Math.min(ans1, ans2);
    }
}