class Solution {
    Map<Integer, Integer> map;
    public int minCostClimbingStairs(int[] cost) {
        map = new HashMap<>();
        return Math.min(help(cost, 0), help(cost, 1));
    }

    int help(int cost[], int i){
        if(i >= cost.length){
            return 0;
        }

        if(map.get(i) != null){
            return map.get(i);
        }

        int ans1 = help(cost, i+1) + cost[i];
        int ans2 = help(cost, i+2) + cost[i];

        map.put(i, Math.min(ans1, ans2));
        return Math.min(ans1, ans2);
    }
}