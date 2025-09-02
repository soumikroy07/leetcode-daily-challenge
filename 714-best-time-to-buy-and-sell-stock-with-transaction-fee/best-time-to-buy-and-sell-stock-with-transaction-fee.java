class Solution {
    int dp[][];
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length+1][2];
        return help(prices, 0, fee, 0);
    }

    private int help(int prices[], int i, int fee, int buy){
        if(i >= prices.length){
            return 0;
        }
        if(dp[i][buy] != 0){
            return dp[i][buy];
        }

        int ans = 0;
        if(buy == 0){
            int ans1 = help(prices, i+1, fee, 1) - prices[i];
            int ans2 = help(prices, i+1, fee, 0);
            ans = Math.max(ans1, ans2);
        }
        else{
            int ans3 = (prices[i] - fee) + help(prices, i+1, fee, 0);
            int ans4 = help(prices, i+1, fee, 1);
            ans = Math.max(ans3, ans4);
        }

        return dp[i][buy] = ans;
    }
}