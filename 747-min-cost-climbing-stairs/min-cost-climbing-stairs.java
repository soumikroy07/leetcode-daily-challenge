class Solution {
    // int dp[];
    Map<Integer, Integer> map;
    public int minCostClimbingStairs(int[] cost) {
        // dp = new int[cost.length+2];
        // Arrays.fill(cost, -1);
        map = new HashMap<>();
        int cost1 = findCost(cost, 0);
        int cost2 = findCost(cost, 1);
        return Math.min(cost1, cost2);
    }

    int findCost(int cost[], int i){
        if(i >= cost.length){
            return 0;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }

        // if(dp[i] != -1){
        //     return dp[i];
        // }
        // int ans = 0;
        int ans1 = cost[i] + findCost(cost, i+1);
        int ans2 = cost[i] + findCost(cost, i+2);

        map.put(i, Math.min(ans1, ans2));
        return Math.min(ans1, ans2);
    }
}