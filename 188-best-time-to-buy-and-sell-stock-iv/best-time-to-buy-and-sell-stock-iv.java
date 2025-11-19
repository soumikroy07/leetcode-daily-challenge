class Solution {
    Integer dp[][][];
    public int maxProfit(int k, int[] prices) {
        dp = new Integer[prices.length + 1][k+1][2];
        return help(prices, 0, k, 0);
    }

    int help(int prices[], int i, int k, int buy){
        if(prices.length <= i || k == 0){
            return 0;
        }
        if(dp[i][k][buy] != null){
            return dp[i][k][buy];
        }
        int ans1 = 0, ans2 = 0, ans3 = 0, ans4 = 0;
        if(buy == 0){
            ans1 = -prices[i] + help(prices, i+1, k, 1);
            ans2 = help(prices, i+1, k, 0);
        }
        else{
            ans3 = prices[i] + help(prices, i+1, k-1, 0);
            ans4 = help(prices, i+1, k, 1);
        }

        return dp[i][k][buy] = Math.max(ans1, Math.max(ans2, Math.max(ans3, ans4)));
    }
}