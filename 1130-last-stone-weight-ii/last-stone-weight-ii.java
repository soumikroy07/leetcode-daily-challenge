class Solution {
    int total = 0;
    int half = 0;
    int dp[][];
    public int lastStoneWeightII(int[] stones) {
        for(int stone: stones){
            total += stone;
        }
        half = total / 2;
        dp = new int[stones.length+1][total];
        return help(stones, 0, 0);
    }

    int help(int stones[], int i, int sum){
        if(sum >= half || i >= stones.length){
            return Math.abs(sum - (total - sum));
        }

        if(dp[i][sum] != 0){
            return dp[i][sum];
        }

        return dp[i][sum] = Math.min(help(stones, i+1, sum), help(stones, i+1, sum + stones[i]));
    }
}