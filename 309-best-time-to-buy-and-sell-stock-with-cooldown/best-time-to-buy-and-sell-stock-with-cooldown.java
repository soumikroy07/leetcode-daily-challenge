class Solution {
    // Map<String, Integer> map = new HashMap<>();
    int dp[][];
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 2][2];
        return helper(0, 0, prices);
    }

    int helper(int i, int hold, int prices[]){
        if(i >= prices.length){
            return 0;
        }

        if(dp[i][hold] != 0){
            return dp[i][hold];
        }
        
        int profit = 0;
        if(hold == 0){
            int buy = helper(i+1, 1, prices) - prices[i];
            int notBuy = helper(i+1, 0, prices);
            profit = Math.max(buy, notBuy);
        }else{
            int sell = helper(i+2, 0, prices) + prices[i];
            int notSell = helper(i+1, 1, prices);
            profit = Math.max(sell, notSell);
        }

        return dp[i][hold]=profit;
    }
}