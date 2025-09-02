class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[] = new int[2*k];
        for(int i=0; i<2*k; i++){
            if(i % 2 == 0){
                dp[i] = Integer.MIN_VALUE;
            }else{
                dp[i] = 0;
            }
        }

        for(int i=0; i<prices.length; i++){
            for(int j=0; j<2*k; j++){
                if(j == 0){
                    dp[j] = Math.max(dp[j], -prices[i]);
                }else if(j % 2 == 0){
                    dp[j] = Math.max(dp[j], dp[j-1] - prices[i]);
                }else{
                    dp[j] = Math.max(dp[j], dp[j-1] + prices[i]);
                }
            }
        }

        return dp[2*k - 1];
    }
}

/*

class Solution {
    public int maxProfit(int k, int[] prices) {
        return help(prices, 0, k, 0, 0);
    }

    int help(int prices[], int i, int k, int buy, int price){
        if(prices.length <= i || k < 0){
            return 0;
        }
        int ans1 = 0, ans2 = 0, ans3 = 0, ans4 = 0;
        if(buy == 0){
            ans1 = help(prices, i+1, k, 1, prices[i]);
            ans2 = help(prices, i+1, k, 0, price);
        }
        else{
            ans3 = (prices[i] - price) + help(prices, i+1, k-1, 0, 0);
            ans4 = help(prices, i+1, k, 1, price);
        }

        return Math.max(ans1, Math.max(ans2, Math.max(ans3, ans4)));
    }
}

*/